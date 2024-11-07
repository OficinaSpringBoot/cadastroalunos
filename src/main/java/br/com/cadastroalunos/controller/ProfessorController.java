package br.com.cadastroalunos.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastroalunos.model.Curso;
import br.com.cadastroalunos.model.Professor;
import br.com.cadastroalunos.service.CursoService;
import br.com.cadastroalunos.service.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @Autowired 
    private CursoService cursoService;

    @PostMapping("/")
    public ResponseEntity<?>createProfessor(@RequestBody Professor professor){
        
        if (professor.getCursos() == null) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("O identificador do curso não pode ser nulo.");
        }

        if (cursoService.findAllById(professor.getCursos()).isEmpty()){
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Não existe nenhum curso com esse identificador.");
        }

        if (service.cpfJaCadastrado(professor.getCpfProfessor())) {
            return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Já existe um Professor com esse CPF cadastrado.");
        }
        Professor newProfessor = service.createProfessor(professor);
        return new ResponseEntity<>(newProfessor, HttpStatus.CREATED);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Professor>> getAllProfessores(){
        List<Professor> allProfessor = service.getAllProfessor();
        return new ResponseEntity<>(allProfessor, HttpStatus.OK);
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<?> getProfessorById(@PathVariable Long matricula){
        Optional<Professor> optionalProfessor = service.getProfessorById(matricula);

        if(optionalProfessor.isPresent()){
            return new ResponseEntity<>(optionalProfessor.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor Not Found");
        }
    }

    @DeleteMapping("/{matricula}")
    public void deleteProfessor(@PathVariable Long matricula){
        service.deleteProfessor(matricula);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long matricula, @RequestBody Professor Professor){
        try {
            Professor updatedProfessor = service.updateProfessor(matricula, Professor);
            return new ResponseEntity<>(updatedProfessor, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}

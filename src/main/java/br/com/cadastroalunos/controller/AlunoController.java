package br.com.cadastroalunos.controller;
import br.com.cadastroalunos.model.Aluno;
import br.com.cadastroalunos.service.AlunoService;
import br.com.cadastroalunos.service.CursoService;

import java.util.Optional;
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

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    
    @Autowired
    private AlunoService service;

    @Autowired
    private CursoService cursoService;

    @PostMapping("/")
    public ResponseEntity<?>createAluno(@RequestBody Aluno aluno){
        
        if (aluno.getCurso() == null) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("O identificador do curso não pode ser nulo.");
        }

        if (cursoService.getCursoById(aluno.getCurso().getIdCurso()).isEmpty()){
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Não existe nenhum curso com esse identificador.");
        }

        if (service.cpfJaCadastrado(aluno.getCpfAluno())) {
            return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Já existe um aluno com esse CPF cadastrado.");
        }
        Aluno newAluno = service.createAluno(aluno);
        return new ResponseEntity<>(newAluno, HttpStatus.CREATED);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Aluno>> getAllAlunos(){
        List<Aluno> allAluno = service.getAllAluno();
        return new ResponseEntity<>(allAluno, HttpStatus.OK);
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<?> getAlunoById(@PathVariable Long matricula){
        Optional<Aluno> optionalAluno = service.getAlunoById(matricula);

        if(optionalAluno.isPresent()){
            return new ResponseEntity<>(optionalAluno.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno Not Found");
        }
    }

    @DeleteMapping("/{matricula}")
    public void deleteAluno(@PathVariable Long matricula){
        service.deleteAluno(matricula);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long matricula, @RequestBody Aluno aluno){
        try {
            Aluno updatedAluno = service.updateAluno(matricula, aluno);
            return new ResponseEntity<>(updatedAluno, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

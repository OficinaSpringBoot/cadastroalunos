package br.com.cadastroalunos.controller;
import br.com.cadastroalunos.model.Aluno;
import br.com.cadastroalunos.model.Curso;
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
@RequestMapping("/api/curso")
public class CursoController {
    @Autowired
    private CursoService service;

    @GetMapping("/")
    public ResponseEntity<List<Curso>> getAllAlunos(){
        List<Curso> cursos = service.getAllCurso();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<?>createAluno(@RequestBody Curso curso){
        var newCurso = service.createCurso(curso);
        return new ResponseEntity<>(newCurso, HttpStatus.CREATED);
    }   

    @DeleteMapping("/{idCurso}")
    public void deleteAluno(@PathVariable Long idCurso){
        service.deleteCurso(idCurso);
    }

    
    // @GetMapping("/{idCurso}")
    // public ResponseEntity<?> getAlunoById(@PathVariable Long idCurso){
    //     Optional<Curso> optCurso = service.getCursoById(idCurso);
    //     if(optCurso.isPresent()){
    //         return new ResponseEntity<>(optCurso.get(), HttpStatus.OK);
    //     } else {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o curso!");
    //     }
    // }

    // @PutMapping("/{idCurso}")
    // public ResponseEntity<Curso> updateAluno(@PathVariable Long idCurso, @RequestBody Curso curso){
    //     try {
    //         var currCurso = service.updateCurso(idCurso, curso);
    //         return new ResponseEntity<>(currCurso, HttpStatus.OK);
    //     }
    //     catch (Exception e){
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }




}

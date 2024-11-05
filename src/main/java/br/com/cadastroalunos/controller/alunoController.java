package br.com.cadastroalunos.controller;
import br.com.cadastroalunos.model.aluno;
import br.com.cadastroalunos.service.alunoService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class alunoController {
    @Autowired
    private alunoService service;

    @PostMapping("/create")
    public ResponseEntity<aluno>createAluno(@RequestBody aluno aluno){
        aluno newAluno = service.createAluno(aluno);
        return new ResponseEntity<>(newAluno, HttpStatus.CREATED);
    }

    
    @GetMapping("/selectAll")
    public ResponseEntity<List<aluno>> getAllAluno(){
        List<aluno> allAluno = service.getAllAluno();
        return new ResponseEntity<>(allAluno, HttpStatus.OK);
    }

    @GetMapping("/select/{matricula}")
    public ResponseEntity<?> getAlunoById(@PathVariable Long matricula){
        Optional<aluno> optionalAluno = service.getAlunoById(matricula);

        if(optionalAluno.isPresent()){
            return new ResponseEntity<>(optionalAluno.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno Not Found");
        }
    }

    @DeleteMapping("/delete/{matricula}")
    public void deleteAluno(@PathVariable Long matricula){
        service.deleteAluno(matricula);
    }

    @PutMapping("/edit/{matricula}")
    public ResponseEntity<aluno> updateAluno(@PathVariable Long matricula, @RequestBody aluno aluno){
        try {
            aluno updatedAluno = service.updateAluno(matricula, aluno);
            return new ResponseEntity<>(updatedAluno, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

package br.com.cadastroalunos.service;

import java.util.List;
import java.util.Optional;

import br.com.cadastroalunos.model.Curso;
import br.com.cadastroalunos.model.Professor;

import org.springframework.stereotype.Service;
import br.com.cadastroalunos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;

    // Create Curso
    public Curso createCurso(Curso curso) {
        return repository.save(curso);
    }

    // List Curso
    public List<Curso> getAllCurso() {
        return repository.findAllByAtivo(true);
    }

    // List by Curso id
    public Optional<Curso> getCursoById(Long idCurso) {
        return repository.findById(idCurso);
    }

    public List<Curso> findAllById(List<Curso> ids){
        return repository.findAllById(ids);
    }


    // Delete Curso
    public void deleteCurso(Long idCurso) {
        // Verifica se o Curso existe
        var curso = repository.findById(idCurso);

        if (curso.isEmpty()) {
            throw new RuntimeException("Curso com id: " + idCurso + " não encontrado");
        }
        var currCurso = curso.get();
        currCurso.setAtivo(false);
        repository.save(currCurso);
    }

    // Update Curso
    public Curso updateCurso(Long matricula, Curso curso) {
        Optional<Curso> oldCurso = repository.findById(matricula);
        if (oldCurso.isPresent()) {
            var newCurso = new Curso(); 
            newCurso.setCargaHoraria(oldCurso.get().getCargaHoraria());
            newCurso.setNomeCurso(oldCurso.get().getNomeCurso());
            return repository.save(newCurso);
        } else {
            throw new RuntimeException("Curso with id: " + matricula + " not found");
        }
    }
}

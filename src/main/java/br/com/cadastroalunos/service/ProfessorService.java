package br.com.cadastroalunos.service;

import br.com.cadastroalunos.model.Professor;
import br.com.cadastroalunos.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    // Create Professor
    public Professor createProfessor(Professor Professor) {
        return repository.save(Professor);
    }

    // List Professor
    public List<Professor> getAllProfessor() {
        return repository.findAll();
    }

    // List by Professor id
    public Optional<Professor> getProfessorById(Long matricula) {
        return repository.findById(matricula);
    }

    // Delete Professor
    public void deleteProfessor(Long matricula) {
        // Verifica se o Professor existe
        if (!repository.existsById(matricula)) {
            throw new RuntimeException("Professor com id: " + matricula + " não encontrado");
        }
        repository.deleteById(matricula);
    }

    // Update Professor
    public Professor updateProfessor(Long matricula, Professor Professor) {
        Optional<Professor> oldProfessor = repository.findById(matricula);
        if (oldProfessor.isPresent()) {
            Professor newProfessor = oldProfessor.get();
            newProfessor.setNomeProfessor(Professor.getNomeProfessor());
            newProfessor.setCpfProfessor(Professor.getCpfProfessor());
            newProfessor.setDataNasc(Professor.getDataNasc());
            newProfessor.setCursos(Professor.getCursos());
            newProfessor.setTelefoneProfessor(Professor.getTelefoneProfessor());
            newProfessor.setEmailProfessor(Professor.getEmailProfessor());
            return repository.save(newProfessor);
        } else {
            throw new RuntimeException("Professor with id: " + matricula + " not found");
        }
    }

    public boolean cpfJaCadastrado(String cpfProfessor) {

        return !repository
                .findByCpfProfessor(cpfProfessor)
                .isEmpty();
    }
}

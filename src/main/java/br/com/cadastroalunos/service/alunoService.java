package br.com.cadastroalunos.service;

import br.com.cadastroalunos.model.aluno;
import br.com.cadastroalunos.repository.alunoRepository;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class alunoService {
    @Autowired
    private alunoRepository repository;

    // Create Aluno
    public aluno createAluno(aluno aluno) {
        return repository.save(aluno);
    }

    // List Aluno
    public List<aluno> getAllAluno() {
        return repository.findAll();
    }

    // List by Aluno id
    public Optional<aluno> getAlunoById(Long matricula) {
        return repository.findById(matricula);
    }

    // Delete Aluno
    public void deleteAluno(Long matricula) {
        // Verifica se o aluno existe
        if (!repository.existsById(matricula)) {
            throw new RuntimeException("Aluno com id: " + matricula + " não encontrado");
        }
        repository.deleteById(matricula);
    }

    // Update Aluno
    public aluno updateAluno(Long matricula, aluno aluno) {
        Optional<aluno> oldAluno = repository.findById(matricula);

        if (oldAluno.isPresent()) {
            aluno newAluno = oldAluno.get();

            newAluno.setNome_aluno(aluno.getNome_aluno());
            newAluno.setCpf_aluno(aluno.getCpf_aluno());
            newAluno.setDta_nasc(aluno.getDta_nasc());
            newAluno.setId_turma(aluno.getId_turma());
            newAluno.setTelefone_aluno(aluno.getTelefone_aluno());
            newAluno.setEmail_aluno(aluno.getEmail_aluno());

            return repository.save(newAluno);
        } else {
            throw new RuntimeException("Aluno with id: " + matricula + " not found");
        }
    }
}

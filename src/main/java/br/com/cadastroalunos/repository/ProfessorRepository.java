package br.com.cadastroalunos.repository;

import br.com.cadastroalunos.model.Professor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    List<Professor> findByCpfProfessor(String cpfProfessor);
}

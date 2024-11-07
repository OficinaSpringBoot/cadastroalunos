package br.com.cadastroalunos.repository;

import br.com.cadastroalunos.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    List<Curso> findAllByAtivo(Boolean ativo);
    List<Curso> findAllById(List<Curso> ids);
}

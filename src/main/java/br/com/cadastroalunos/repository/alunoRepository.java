package br.com.cadastroalunos.repository;
import br.com.cadastroalunos.model.aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface alunoRepository extends JpaRepository<aluno, Long> {
}
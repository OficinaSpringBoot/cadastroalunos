package br.com.cadastroalunos.repository;
import br.com.cadastroalunos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
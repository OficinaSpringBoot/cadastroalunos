package br.com.cadastroalunos.repository;
import br.com.cadastroalunos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByCpfAluno(String cpfAluno);
}
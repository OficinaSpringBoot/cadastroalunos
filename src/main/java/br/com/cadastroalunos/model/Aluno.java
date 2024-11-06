package br.com.cadastroalunos.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long matricula;

    @Column(unique = true, nullable = false)
    String cpfAluno;

    Long idTurma;
    String nomeAluno, telefoneAluno, emailAluno, dataNasc;
}

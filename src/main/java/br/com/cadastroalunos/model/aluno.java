package br.com.cadastroalunos.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class aluno {
    @Id
    Long matricula;
    Long id_turma;
    String nome_aluno, telefone_aluno, email_aluno, dta_nasc;
    @Column(unique = true, nullable = false)
    String cpf_aluno;
}

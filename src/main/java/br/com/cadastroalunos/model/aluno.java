package br.com.cadastroalunos.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "aluno")
@Data
@AllArgsConstructor
public class aluno {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long matricula;
    Long id_turma;
    String nome_aluno, telefone_aluno, email_aluno, dta_nasc;
    @Column(unique = true, nullable = false)
    String cpf_aluno;
}

package br.com.cadastroalunos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long matricula;

    @Column(unique = true, nullable = false)
    String cpfProfessor;

    String nomeProfessor, telefoneProfessor, emailProfessor, dataNasc;

    @Enumerated(EnumType.ORDINAL)
    private Area area;

    @ManyToMany
    List<Curso> cursos;

}

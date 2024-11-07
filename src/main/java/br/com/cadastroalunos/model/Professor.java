package br.com.cadastroalunos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinTable(
        name = "course_like", 
        joinColumns = @JoinColumn(name = "id_curso"),
        inverseJoinColumns = @JoinColumn(name = "id_professor")
    )
    List<Curso> cursos;

}

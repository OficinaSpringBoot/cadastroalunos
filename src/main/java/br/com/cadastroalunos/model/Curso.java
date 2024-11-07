package br.com.cadastroalunos.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idCurso;

    @Column(unique = true, nullable = false)
    String nomeCurso;

    Long cargaHoraria;

    Boolean ativo;

    @ManyToMany
    @JoinTable(
        name = "course_like", 
        joinColumns = @JoinColumn(name = "id_professor"), 
        inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    List<Professor> professores;
}

package org.serratec.aula06.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String comentario;

    @Min(1)
    @Max(5)
    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    @JsonIgnoreProperties("avaliacoes")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    @JsonIgnoreProperties("avaliacoes")
    private Aluno aluno;

	public Avaliacao() {
		super();
	}

	public Avaliacao(Long id, @NotBlank String comentario, @Min(1) @Max(5) Integer nota, Curso curso, Aluno aluno) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.nota = nota;
		this.curso = curso;
		this.aluno = aluno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
    
    

}

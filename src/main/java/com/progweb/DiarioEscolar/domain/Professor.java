package com.progweb.DiarioEscolar.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "professor")
public class Professor extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "formacao")
	private String formacao;
	
	//RELACIONAMENTO
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Turma> turmas = new ArrayList<>();


	public Professor(Long id, String nome, String matricula, String email, String formacao) {
		super(id, nome, matricula, email);
		this.formacao = formacao;
	}

	public Professor() {
		super();
	}

	

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	


}

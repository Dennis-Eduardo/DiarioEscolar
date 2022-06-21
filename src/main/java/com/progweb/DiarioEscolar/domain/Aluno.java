package com.progweb.DiarioEscolar.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "aluno")
public class Aluno extends Pessoa{
	private static final long serialVersionUID = 1L;

	// RELACIONAMENTO
	@JsonIgnore
	@ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "aluno_turma", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "turma_id"))
	private List<Turma> turmas = new ArrayList<>();

	public Aluno(Long id, String nome, String matricula, String email) {
		super(id, nome, matricula, email);
	}

	public Aluno() {
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	

	

}

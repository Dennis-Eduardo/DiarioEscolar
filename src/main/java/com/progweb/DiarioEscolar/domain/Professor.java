package com.progweb.DiarioEscolar.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

	
	@OneToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;


}

package com.progweb.DiarioEscolar.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "projeto")
public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Column
    private String nome;
    @Column
    private String descricao;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id")
    private Professor professor;//trocar para coordenador

    @JsonIgnore
    @OneToMany(mappedBy = "projeto", fetch = FetchType.EAGER)
    private List<Aluno> alunos = new ArrayList<>();

    public void addAluno(Aluno aluno){
		this.alunos.add(aluno);
	}
}



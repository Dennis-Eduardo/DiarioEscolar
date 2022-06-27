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
    private String descrição;

    @OneToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @JsonIgnore
    @OneToMany(mappedBy = "projeto", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    private List<Aluno> alunos = new ArrayList<>();
}



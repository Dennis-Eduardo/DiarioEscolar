package com.progweb.DiarioEscolar.domain.dtos;

import java.util.List;

import com.progweb.DiarioEscolar.domain.Aluno;
import com.progweb.DiarioEscolar.domain.Professor;

public class TurmaDTO {
    
    private Long id;
    private String nome;
	private String sala;
   // private List<Aluno> alunos;
    private Professor professor;

    
    public TurmaDTO(Long id, String nome, String sala) {
        this.id = id;
        this.nome = nome;
        this.sala = sala;
    }

    public TurmaDTO() {
        
    }

    //public List<Aluno> getAlunos() {
       // return alunos;
    //}

    //public void setAlunos(List<Aluno> alunos) {
       // this.alunos = alunos;
    //}

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnome() {
        return nome;
    }
    public void setnome(String nome) {
        this.nome = nome;
    }
    public String getSala() {
        return sala;
    }
    public void setSala(String sala) {
        this.sala = sala;
    }

    
}
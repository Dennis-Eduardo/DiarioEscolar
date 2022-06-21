package com.progweb.DiarioEscolar.domain.dtos;

public class ProfessorDTO {
    
    private Long id;
    private String nome;
    private String formacao;
    private String matricula;
    private String email;
    
    public ProfessorDTO() {
    }

    public ProfessorDTO(Long id, String nome, String formacao, String matricula, String email) {
        this.id = id;
        this.nome = nome;
        this.formacao = formacao;
        this.matricula = matricula;
        this.email = email;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFormacao() {
        return formacao;
    }
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
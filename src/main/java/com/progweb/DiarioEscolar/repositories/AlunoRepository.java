package com.progweb.DiarioEscolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progweb.DiarioEscolar.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    public Boolean findByNomeAlunoBoolean(String nome);
}

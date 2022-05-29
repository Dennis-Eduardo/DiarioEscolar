package com.progweb.DiarioEscolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progweb.DiarioEscolar.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    public Boolean findByNomeTurmaBoolean(String nome);

}

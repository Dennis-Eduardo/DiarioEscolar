package com.progweb.DiarioEscolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progweb.DiarioEscolar.domain.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Integer> {

}

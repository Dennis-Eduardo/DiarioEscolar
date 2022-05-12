package com.progweb.DiarioEscolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progweb.DiarioEscolar.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}

package com.progweb.DiarioEscolar.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progweb.DiarioEscolar.domain.Alunos;
import com.progweb.DiarioEscolar.repositories.AlunosRepository;

@Service
public class AlunosService {
	
	@Autowired
	private AlunosRepository alunosRepository;
	
	public Alunos buscar(Integer id) {
		
		Optional<Alunos> obj = alunosRepository.findById(id);
		
		return obj.orElse(null);
		
	}

}

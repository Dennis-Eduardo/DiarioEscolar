package com.progweb.DiarioEscolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progweb.DiarioEscolar.domain.Professor;
import com.progweb.DiarioEscolar.repositories.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<Professor> ListarProfessor (){
		return professorRepository.findAll();
	}

	public Professor adicionarAluno(Professor professor){
		return professorRepository.save(professor);
	}

	public Optional<Professor> buscarProfessor(Long professorID){
		return professorRepository.findById(professorID);
	}

	public boolean verificarProfessorExiste(Long professorID){
		return professorRepository.existsById(professorID);
	}

	public Professor atualizarProfessor(Long id, Professor professor){
		professor.setId(id);
		return professorRepository.save(professor);
	}
	public void deletarProfessor(Long professorID){
		professorRepository.deleteById(professorID);
	}

}

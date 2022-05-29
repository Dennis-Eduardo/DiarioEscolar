package com.progweb.DiarioEscolar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

import com.progweb.DiarioEscolar.domain.Professor;
import com.progweb.DiarioEscolar.exceptions.ExistingObjectSameNameException;
import com.progweb.DiarioEscolar.repositories.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<Professor> ListarProfessor (){
		return professorRepository.findAll();
	}

	public Professor adicionarProfessor(Professor professor) throws ExistingObjectSameNameException{
		if (professorRepository.findByNomeProfessorBoolean(professor.getNome()))
            throw new ExistingObjectSameNameException("Já existe um professor com esse nome!");
		return professorRepository.save(professor);
	}

	public Professor buscarProfessor(Long professorID) throws NotFoundException{
		return professorRepository.findById(professorID).orElseThrow(() -> new NotFoundException("Não existe um professor com esse id!"));
	}

	public boolean verificarSeProfessorExiste(Long professorID){
		return professorRepository.existsById(professorID);
	}

	public Professor atualizarProfessor(Long id, Professor professor){
		professor.setId(id);

		return professorRepository.save(professor);
	}
	
	public void deletarProfessor(Long professorID){
		Professor professorToDelete = professorRepository.findById(professorID).get();
        professorRepository.delete(professorToDelete);
	}

}

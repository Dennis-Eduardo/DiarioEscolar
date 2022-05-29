package com.progweb.DiarioEscolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progweb.DiarioEscolar.domain.Aluno;
import com.progweb.DiarioEscolar.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> ListarAlunos (){
		return alunoRepository.findAll();
	}

	public Aluno adicionarAluno(Aluno aluno){
		return alunoRepository.save(aluno);
	}

	public Optional<Aluno> buscarAluno(Long alunoID){
		return alunoRepository.findById(alunoID);
	}

	public boolean verificarSeAlunoExiste(Long alunoID){
		return alunoRepository.existsById(alunoID);
	}

	public Aluno atualizarAluno(Long id, Aluno aluno){
		aluno.setId(id);

		return alunoRepository.save(aluno);
	}

	public void deletarAluno(Long alunoID){
		alunoRepository.deleteById(alunoID);
	}

}

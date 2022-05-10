package com.progweb.DiarioEscolar.services;

import java.util.List;

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
		//verificacao se matricula igual
		//boolean jaExiste = alunoRepository.existsById(aluno.getId());
		//if(!jaExiste){
		//	throw new IllegalStateException("Aluno Já Cadastrado");
		//}

		return alunoRepository.save(aluno);
	}

	public void pegarAluno(Long alunoID){
		//verificacao
		boolean existe = alunoRepository.existsById(alunoID);
		if(!existe){
			throw new IllegalStateException("Aluno não encontrado");
		}
		
		alunoRepository.findById(alunoID);
	}

	public Aluno atualizarAluno(Long alunoID, Aluno aluno){
		//verificacao
		boolean existe = alunoRepository.existsById(alunoID);
		if(!existe){
			throw new IllegalStateException("Aluno não encontrado");
		}

		return alunoRepository.save(aluno);
	}



	public void deletarAluno(Long alunoID){
		//verificacao
		boolean existe = alunoRepository.existsById(alunoID);
		if(!existe){
			throw new IllegalStateException("Aluno não encontrado");
		}

		alunoRepository.deleteById(alunoID);
	}

}

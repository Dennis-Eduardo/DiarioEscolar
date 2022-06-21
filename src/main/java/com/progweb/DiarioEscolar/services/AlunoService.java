package com.progweb.DiarioEscolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progweb.DiarioEscolar.domain.Aluno;
import com.progweb.DiarioEscolar.repositories.AlunoRepository;
import com.progweb.DiarioEscolar.services.exceptions.ExistingObjectSameNameException;
import com.progweb.DiarioEscolar.services.exceptions.ObjectNotFoundException;


@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public Aluno encontrarPorID(Long id){
		Optional<Aluno> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! id : "+ id));
    }

	public List<Aluno> ListarAlunos (){
		return repository.findAll();
	}

	public Aluno adicionarAluno(Aluno aluno) throws ExistingObjectSameNameException{
		
		return repository.save(aluno);
	}


	public Aluno atualizarAluno(Long id, Aluno aluno){
		aluno.setId(id);
        return repository.save(aluno);
		
	}

	public void deletarAluno(Long id){
		Aluno aluno = encontrarPorID(id);
        repository.deleteById(aluno.getId());
	}

}

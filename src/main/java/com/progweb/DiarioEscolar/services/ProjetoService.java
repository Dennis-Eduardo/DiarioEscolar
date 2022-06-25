package com.progweb.DiarioEscolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progweb.DiarioEscolar.domain.Aluno;
import com.progweb.DiarioEscolar.domain.Projeto;
import com.progweb.DiarioEscolar.repositories.AlunoRepository;
import com.progweb.DiarioEscolar.repositories.ProjetoRepository;
import com.progweb.DiarioEscolar.services.exceptions.ExistingObjectSameNameException;
import com.progweb.DiarioEscolar.services.exceptions.ObjectNotFoundException;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	public Projeto encontrarPorID(Long id){
		Optional<Projeto> obj = projetoRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! id : "+ id));
    }

	public List<Projeto> ListarProjetos (){
		return projetoRepository.findAll();
	}

	public Projeto adicionarProjeto(Projeto projeto) throws ExistingObjectSameNameException{
		
		return projetoRepository.save(projeto);
	}


	public Projeto atualizarProjeto(Long id, Projeto projeto){
		projeto.setId(id);
        return projetoRepository.save(projeto);
		
	}

	public void deletarProjeto(Long id){
		Projeto projeto = encontrarPorID(id);
		projetoRepository.deleteById(projeto.getId());
	}


}

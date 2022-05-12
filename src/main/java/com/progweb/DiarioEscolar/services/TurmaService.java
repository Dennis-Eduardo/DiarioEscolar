package com.progweb.DiarioEscolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progweb.DiarioEscolar.domain.Turma;
import com.progweb.DiarioEscolar.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public List<Turma> ListarTurmas (){
		return turmaRepository.findAll();
	}

	public Turma adicionarTurma(Turma turma){
		return turmaRepository.save(turma);
	}

	public Optional<Turma> pegarTurma(Long turmaID){
		return turmaRepository.findById(turmaID);
	}

	public boolean verificarTurmaExiste(Long turmaID){
		return turmaRepository.existsById(turmaID);
	}

	public Turma atualizarTurma(Long id, Turma turma){
		turma.setId(id);
		return turmaRepository.save(turma);
	}
	public void deletarTurma(Long turmaID){
		turmaRepository.deleteById(turmaID);
	}

}

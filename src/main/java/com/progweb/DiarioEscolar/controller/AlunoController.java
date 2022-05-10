package com.progweb.DiarioEscolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.progweb.DiarioEscolar.domain.Aluno;
import com.progweb.DiarioEscolar.services.AlunoService;

@RestController
@RequestMapping(value= "/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping()
	public List<Aluno> ListarAlunos(){
		return alunoService.ListarAlunos();
	}
	
	@PostMapping
	public Aluno registrarAluno(@RequestBody Aluno aluno){
		return alunoService.adicionarAluno(aluno);
	}

	@GetMapping("/{alunoID}")
	public void pegarAluno(@PathVariable("alunoID") Long alunoID){
		alunoService.pegarAluno(alunoID);
	}

	@PutMapping("/{alunoID}")
	public Aluno atualizarAluno(@PathVariable("AlunoID") Long alunoID, @RequestBody Aluno aluno){
		return alunoService.atualizarAluno(alunoID, aluno);
	}

	@DeleteMapping("/{alunoID}")
	public void deletarAluno(@PathVariable("alunoID") Long alunoID){
		alunoService.deletarAluno(alunoID);
	}

}

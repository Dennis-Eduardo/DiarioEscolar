package com.progweb.DiarioEscolar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import com.progweb.DiarioEscolar.domain.Aluno;
import com.progweb.DiarioEscolar.services.AlunoService;

@RestController
@RequestMapping(value= "/alunos")
@Api(value = "Aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping()
	@ApiOperation(value = "Retorna a lista de todos os alunos cadastrados.")
	public ResponseEntity<List<Aluno>> listarAlunos(){
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.ListarAlunos());
	}
	
	
	@PostMapping
	@ApiOperation(value = "Cadastra um novo aluno.")
	public ResponseEntity<Object> registrarAluno(@RequestBody Aluno aluno){
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.adicionarAluno(aluno));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um aluno pelo seu {id}.")
	public ResponseEntity<Object> buscarAluno(@PathVariable Long id){
		boolean alunoExiste = alunoService.verificarSeAlunoExiste(id);

		if(!alunoExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.buscarAluno(id).get());

	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza os dados de um aluno.")
	public ResponseEntity<Object> atualizarAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno){
		boolean alunoExiste = alunoService.verificarSeAlunoExiste(id);
		
		if(!alunoExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.atualizarAluno(id, aluno));

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um aluno cadastrado.")
	public ResponseEntity<Object> deletarAluno(@PathVariable("id") Long id){
		boolean alunoExiste = alunoService.verificarSeAlunoExiste(id);
		
		if(!alunoExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
		}
		alunoService.deletarAluno(id);
		return ResponseEntity.status(HttpStatus.OK).body("Aluno Deletado com sucesso");

	}

}

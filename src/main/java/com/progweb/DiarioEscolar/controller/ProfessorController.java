package com.progweb.DiarioEscolar.controller;

import java.util.List;

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

import com.progweb.DiarioEscolar.domain.Professor;
import com.progweb.DiarioEscolar.services.ProfessorService;

@RestController
@RequestMapping(value = "/professores")
@Api(value = "Professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping()
	@ApiOperation(value = "Retorna a lista de todos os professores cadastrados.")
	public ResponseEntity<List<Professor>> listarProfessores(){
		return ResponseEntity.status(HttpStatus.OK).body(professorService.ListarProfessor());
	}
	
	@PostMapping
	@ApiOperation(value = "Cadastra um novo professor.")
	public ResponseEntity<Object> registrarProfessor(@RequestBody Professor professor){
		return ResponseEntity.status(HttpStatus.CREATED).body(professorService.adicionarProfessor(professor));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um professor pelo seu {id}.")
	public ResponseEntity<Object> buscarProfessor(@PathVariable Long id){
		boolean professorExiste = professorService.verificarSeProfessorExiste(id);

		if(!professorExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(professorService.buscarProfessor(id).get());

	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza os dados de um professor.")
	public ResponseEntity<Object> atualizarProfessor(@PathVariable("id") Long id, @RequestBody Professor professor){
		boolean professorExiste = professorService.verificarSeProfessorExiste(id);
		
		if(!professorExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado");
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(professorService.atualizarProfessor(id, professor));

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um professor cadastrado.")
	public ResponseEntity<Object> deletarProfessor(@PathVariable("id") Long id){
		boolean professorExiste = professorService.verificarSeProfessorExiste(id);
		
		if(!professorExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado");
		}
		professorService.deletarProfessor(id);
		return ResponseEntity.status(HttpStatus.OK).body("Professor Deletado com sucesso");

	}
	
	

}

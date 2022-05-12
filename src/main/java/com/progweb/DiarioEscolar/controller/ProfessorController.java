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

import com.progweb.DiarioEscolar.domain.Professor;
import com.progweb.DiarioEscolar.services.ProfessorService;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping()
	public ResponseEntity<List<Professor>> ListarProfessores(){
		return ResponseEntity.status(HttpStatus.OK).body(professorService.ListarProfessor());
	}
	
	@PostMapping
	public ResponseEntity<Object> registrarProfessor(@RequestBody Professor professor){
		return ResponseEntity.status(HttpStatus.CREATED).body(professorService.adicionarAluno(professor));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> BuscarProfessor(@PathVariable Long id){
		boolean professorExiste = professorService.verificarProfessorExiste(id);

		if(!professorExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(professorService.buscarProfessor(id).get());

	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarProfessor(@PathVariable("id") Long id, @RequestBody Professor professor){
		boolean professorExiste = professorService.verificarProfessorExiste(id);
		
		if(!professorExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado");
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(professorService.atualizarProfessor(id, professor));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarProfessor(@PathVariable("id") Long id){
		boolean professorExiste = professorService.verificarProfessorExiste(id);
		
		if(!professorExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado");
		}
		professorService.deletarProfessor(id);
		return ResponseEntity.status(HttpStatus.OK).body("Professor Deletado com sucesso");

	}
	
	

}

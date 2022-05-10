package com.progweb.DiarioEscolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.progweb.DiarioEscolar.domain.Alunos;
import com.progweb.DiarioEscolar.services.AlunosService;

@RestController
@RequestMapping(value= "/alunos")
public class AlunosController {
	
	@Autowired
	private AlunosService alunoService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Alunos obj = alunoService.buscar(id);
		return ResponseEntity.ok().body(obj);
		
		
	}

}

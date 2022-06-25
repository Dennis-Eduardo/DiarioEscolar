package com.progweb.DiarioEscolar.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.progweb.DiarioEscolar.domain.Projeto;
import com.progweb.DiarioEscolar.domain.dtos.ProjetoDTO;
import com.progweb.DiarioEscolar.mappers.ProjetoMapper;
import com.progweb.DiarioEscolar.services.ProjetoService;
import com.progweb.DiarioEscolar.services.exceptions.ExistingObjectSameNameException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value= "/projetos")
@Api(value = "Projeto")
public class ProjetoController {
	
	@Autowired
	private ProjetoService service;
	
	@Autowired
	private ProjetoMapper projetoMapper;
	
	@GetMapping()
	@ApiOperation(value = "Retorna a lista de todos os projetos cadastrados.")
	public List<ProjetoDTO> listarProjetos() {
        List<Projeto> projetos = service.ListarProjetos();
        return projetos.stream()
						.map(projetoMapper::convertToProjetoDTO)
                        .collect(Collectors.toList());
    }
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um projeto pelo seu {id}.")
	public ResponseEntity<?> buscarProjeto(@PathVariable Long id){
        return new ResponseEntity<>(projetoMapper.convertToProjetoDTO(service.encontrarPorID(id)), HttpStatus.OK);

	}
	
	@PostMapping
	@ApiOperation(value = "Cadastra um novo projeto.")
	public ResponseEntity<ProjetoDTO> registrarProjeto(@RequestBody ProjetoDTO projetoDTO) throws ExistingObjectSameNameException{
		
        Projeto projeto = projetoMapper.convertFromProjetoDTO(projetoDTO);
		Projeto novoProjeto=  service.adicionarProjeto(projeto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoProjeto.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza os dados de um projeto.")
	public ResponseEntity<ProjetoDTO> atualizarProjeto(@PathVariable Long id, @RequestBody ProjetoDTO projetoDTO){
		
		Projeto projeto = projetoMapper.convertFromProjetoDTO(projetoDTO);
		ProjetoDTO projetoAtualizado =  projetoMapper.convertToProjetoDTO(service.atualizarProjeto(id, projeto));

		return ResponseEntity.ok().body(projetoAtualizado);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um projeto cadastrado.")
	public ResponseEntity<?> deletarProjeto(@PathVariable Long id){
		
		service.deletarProjeto(id);
		return ResponseEntity.status(HttpStatus.OK).body("Projeto Deletado com sucesso");

	}

}

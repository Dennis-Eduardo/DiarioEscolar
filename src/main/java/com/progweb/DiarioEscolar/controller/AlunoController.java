package com.progweb.DiarioEscolar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.stream.Collectors;

import com.progweb.DiarioEscolar.domain.Aluno;
import com.progweb.DiarioEscolar.dto.AlunoDTO;
import com.progweb.DiarioEscolar.exceptions.ExistingObjectSameNameException;
import com.progweb.DiarioEscolar.services.AlunoService;
import com.progweb.DiarioEscolar.settings.mappers.AlunoMapper;

import javassist.NotFoundException;


@RestController
@RequestMapping(value= "/alunos")
@Api(value = "Aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;

	@Autowired
    private AlunoMapper alunoMapper;
	
	@GetMapping()
	@ApiOperation(value = "Retorna a lista de todos os alunos cadastrados.")
	public List<AlunoDTO> listarAlunos() {
        List<Aluno> alunos = alunoService.ListarAlunos();
        return alunos.stream()
						.map(alunoMapper::convertToAlunoDTO)
                        .collect(Collectors.toList());
    }
	
	
	@PostMapping
	@ApiOperation(value = "Cadastra um novo aluno.")
	public ResponseEntity<Object> registrarAluno(@RequestBody AlunoDTO alunoDTO) throws ExistingObjectSameNameException{
		try {
            Aluno aluno = alunoMapper.convertFromAlunoDTO(alunoDTO);
            return new ResponseEntity<>(alunoService.adicionarAluno(aluno), HttpStatus.CREATED);

        } catch (ExistingObjectSameNameException e) {
            return ResponseEntity.badRequest().body("Nome do aluno ja Registrado");
        }
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um aluno pelo seu {id}.")
	public ResponseEntity<?> buscarAluno(@PathVariable Long id){
		try {
            return new ResponseEntity<>(alunoMapper.convertToAlunoDTO(alunoService.buscarAluno(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body("Aluno não encontrado");
        }
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza os dados de um aluno.")
	public AlunoDTO atualizarAluno(@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO){
		Aluno aluno = alunoMapper.convertFromAlunoDTO(alunoDTO);
        return alunoMapper.convertToAlunoDTO(alunoService.atualizarAluno(id, aluno));

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

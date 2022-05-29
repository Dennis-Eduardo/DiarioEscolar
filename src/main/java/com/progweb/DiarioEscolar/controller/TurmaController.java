package com.progweb.DiarioEscolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.progweb.DiarioEscolar.domain.Turma;
import com.progweb.DiarioEscolar.services.AlunoService;
import com.progweb.DiarioEscolar.services.ProfessorService;
import com.progweb.DiarioEscolar.services.TurmaService;

@RestController
@RequestMapping(value = "/turmas")
@Api(value = "Aluno")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;

    @Autowired
	private ProfessorService professorService;

	@Autowired
	private AlunoService alunoService;
	
	
	@GetMapping()
	@ApiOperation(value = "Retorna a lista de todas as turmas cadastrados.")
	public ResponseEntity<List<Turma>> listarTurmas(){
		return ResponseEntity.status(HttpStatus.OK).body(turmaService.ListarTurmas());
	}
	
	@PostMapping
	@ApiOperation(value = "Cadastra uma nova turma.")
	public ResponseEntity<Object> registrarTurma(@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.adicionarTurma(turma));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma turma pelo seu {id}.")
	public ResponseEntity<Object> buscarTurma(@PathVariable Long id){
		boolean turmaExiste = turmaService.verificarSeTurmaExiste(id);

		if(!turmaExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
		}
		return ResponseEntity.status(HttpStatus.OK).body(turmaService.buscarTurma(id).get());

	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza os dados de uma turma.")
	public ResponseEntity<Object> atualizarTurma(@PathVariable("id") Long id, @RequestBody Turma turma){
		boolean turmaExiste = turmaService.verificarSeTurmaExiste(id);
		
		if(!turmaExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.atualizarTurma( turma));

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma turma Cadastrado.")
	public ResponseEntity<Object> deletarTurma(@PathVariable("id") Long id){
		boolean turmaExiste = turmaService.verificarSeTurmaExiste(id);
		
		if(!turmaExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
		}
		turmaService.deletarTurma(id);
		return ResponseEntity.status(HttpStatus.OK).body("Turma Deletada com sucesso");

	}

    //PATCH
	
	@PatchMapping("/{idTurma}/matricularAluno/{idAluno}")
	@ApiOperation(value = "Matricular um aluno a uma turma.")
    public ResponseEntity<Object> matricularAluno(@PathVariable("idTurma") Long idTurma,@PathVariable("idAluno") Long idAluno, @RequestBody Turma turma){
        boolean turmaExiste = turmaService.verificarSeTurmaExiste(idTurma);
        boolean alunoExiste = alunoService.verificarSeAlunoExiste(idAluno);

		if(!turmaExiste || !alunoExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma ou Aluno não encontrado");
		}

        turmaService.matricularAluno(idTurma, idAluno);

        return ResponseEntity.status(HttpStatus.OK).body("Aluno Matriculado com sucesso");
    }

	@PatchMapping("/{idTurma}/vincularProfessor/{idProf}")
	@ApiOperation(value = "Vincula um Professor a uma turma.")
    public ResponseEntity<Object> vincularProfessor(@PathVariable("idTurma") Long idTurma,@PathVariable("idProf") Long idProf, @RequestBody Turma turma){
        boolean turmaExiste = turmaService.verificarSeTurmaExiste(idTurma);
        boolean profExiste = professorService.verificarSeProfessorExiste(idProf);

		if(!turmaExiste || !profExiste){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma ou Professor não encontrado");
		}

        turmaService.vincularProfessor(idTurma, idProf);

        return ResponseEntity.status(HttpStatus.OK).body("Professor Vinculado com sucesso");
    }

	

}

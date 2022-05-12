package com.progweb.DiarioEscolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progweb.DiarioEscolar.domain.Aluno;
import com.progweb.DiarioEscolar.domain.Professor;
import com.progweb.DiarioEscolar.domain.Turma;
import com.progweb.DiarioEscolar.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;

    @Autowired
    private ProfessorService professorService;

	@Autowired
    private AlunoService alunoService;
	
	public List<Turma> ListarTurmas (){
		return turmaRepository.findAll();
	}

	public Turma adicionarTurma(Turma turma){
		return turmaRepository.save(turma);
	}

	public Optional<Turma> buscarTurma(Long turmaID){
		return turmaRepository.findById(turmaID);
	}

	public boolean verificarSeTurmaExiste(Long turmaID){
		return turmaRepository.existsById(turmaID);
	}

	public Turma atualizarTurma(Long id, Turma turma){
		turma.setId(id);
		return turmaRepository.save(turma);
	}
	public void deletarTurma(Long turmaID){
		turmaRepository.deleteById(turmaID);
	}


	
    public void vincularProfessor(Long idTurma, Long idProf, Turma turma){

        Professor professor = professorService.buscarProfessor(idProf).get();   

        turma.getProfessores().add(professor);
        professor.getTurmas().add(turma);

        //atualizar professor/turma e nao adicionar
        professorService.adicionarProfessor(professor);
        turmaRepository.save(turma);
    }

	public void matricularAluno(Long idTurma, Long idAluno, Turma turma){

        Aluno aluno = alunoService.buscarAluno(idAluno).get();

        turma.getAlunos().add(aluno);
        aluno.getTurmas().add(turma);

        //atualizar aluno/turma e nao adicionar
        alunoService.adicionarAluno(aluno);
        turmaRepository.save(turma);
    }
}

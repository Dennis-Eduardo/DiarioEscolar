package com.progweb.DiarioEscolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progweb.DiarioEscolar.domain.Aluno;
import com.progweb.DiarioEscolar.domain.Professor;
import com.progweb.DiarioEscolar.domain.Projeto;
import com.progweb.DiarioEscolar.repositories.AlunoRepository;
import com.progweb.DiarioEscolar.repositories.ProfessorRepository;
import com.progweb.DiarioEscolar.repositories.ProjetoRepository;
import com.progweb.DiarioEscolar.services.exceptions.ExistingObjectSameNameException;
import com.progweb.DiarioEscolar.services.exceptions.ObjectNotFoundException;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository repository;
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private ProfessorService professorService;
	
	public Projeto encontrarPorID(Long id){
		Optional<Projeto> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! id : "+ id));
    }

	public List<Projeto> ListarProjetos (){
		return repository.findAll();
	}

	public Projeto adicionarProjeto(Projeto projeto) throws ExistingObjectSameNameException{
		return repository.save(projeto);
	}


	public Projeto atualizarProjeto(Long id, Projeto projeto){
		projeto.setId(id);
        return repository.save(projeto);
		
	}

	public void deletarProjeto(Long id){
		Projeto projeto = encontrarPorID(id);
		repository.deleteById(projeto.getId());
	}

	public Projeto vincularProfessor(Long idProjeto, Long idProf){

        Professor professor = professorService.encontrarPorID(idProf); 
		Projeto projeto= repository.findById(idProjeto).get();

		projeto.setProfessor(professor);
		professor.setProjeto(projeto);

        professorService.atualizarProfessor(idProf, professor);
        return this.atualizarProjeto(idProjeto, projeto);
    }

	public Projeto adicionarAluno(Long idProf, Long idAluno){

        Aluno aluno = alunoService.encontrarPorID(idAluno);
		Projeto projeto = professorService.encontrarPorID(idProf).getProjeto();


		projeto.getAlunos().add(aluno);
		aluno.setProjeto(projeto);

		alunoService.atualizarAluno(aluno.getId(),aluno);
		return this.atualizarProjeto(projeto.getId(), projeto);
    }


}
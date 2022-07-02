package com.progweb.DiarioEscolar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.progweb.DiarioEscolar.domain.Aluno;
import com.progweb.DiarioEscolar.domain.Professor;

import com.progweb.DiarioEscolar.services.AlunoService;
import com.progweb.DiarioEscolar.services.ProfessorService;

@SpringBootApplication
public class DiarioEscolarApplication implements CommandLineRunner{

	@Autowired
	private AlunoService alunoService;
	@Autowired
	private ProfessorService professorService; 
	@Autowired 
	private BCryptPasswordEncoder encoder;

	
	public static void main(String[] args) {
		SpringApplication.run(DiarioEscolarApplication.class, args);
	}


	//instanciar uma conta padrao no banco de dados de aluno e professor
	@Override
	public void run(String... args) throws Exception{
		
		Aluno aluno1 = new Aluno("aluno123","1910804381", "aluno123@gmail.com", encoder.encode("aluno123"));
		Professor prof1 = new Professor("prof123","190120122", "Hitoria","prof123@gmail.com",encoder.encode("prof123") );
		
		alunoService.adicionarAluno(aluno1);
		professorService.adicionarProfessor(prof1);
	}

}

package com.progweb.DiarioEscolar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.progweb.DiarioEscolar.domain.Aluno;
import com.progweb.DiarioEscolar.domain.Professor;
import com.progweb.DiarioEscolar.repositories.AlunoRepository;
import com.progweb.DiarioEscolar.repositories.ProfessorRepository;

@SpringBootApplication
public class DiarioEscolarApplication implements CommandLineRunner{

	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private ProfessorRepository professorRepository; 
	@Autowired 
	private BCryptPasswordEncoder encoder;

	public static void main(String[] args) {
		///iniciar um aluno e professor padrao
		SpringApplication.run(DiarioEscolarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		//instanciar um padrao no banco de dados
		Aluno aluno1 = new Aluno("aluno123","1910804381", "aluno123@gmail.com", encoder.encode("aluno123"));
		Professor prof1 = new Professor("prof123","190120122", "Hitoria","prof123@gmail.com",encoder.encode("prof123") );
		
		alunoRepository.save(aluno1);
		professorRepository.save(prof1);
	}

}

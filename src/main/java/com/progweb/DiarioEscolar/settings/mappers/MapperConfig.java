package com.progweb.DiarioEscolar.settings.mappers;



import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public AlunoMapper alunoMapper() {
        return new AlunoMapper();
    }

    @Bean
    public ProfessorMapper professorMapper() {
        return new ProfessorMapper();
    }

    @Bean
    public TurmaMapper turmaMapper() {
        return new TurmaMapper();
    }

}

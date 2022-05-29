package com.progweb.DiarioEscolar.settings.mappers;


import java.util.Optional;

import com.progweb.DiarioEscolar.domain.Aluno;
import com.progweb.DiarioEscolar.dto.AlunoDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AlunoMapper {

    @Autowired
    private static ModelMapper modelMapper;
    
    public AlunoDTO convertToAlunoDTO(Aluno aluno) {
        AlunoDTO alunoDTO = modelMapper.map(aluno, AlunoDTO.class);

        return alunoDTO;
    }

    public Aluno convertFromAlunoDTO(AlunoDTO alunoDTO) {
        Aluno aluno = modelMapper.map(alunoDTO, Aluno.class);
    
        return aluno;
    }
}

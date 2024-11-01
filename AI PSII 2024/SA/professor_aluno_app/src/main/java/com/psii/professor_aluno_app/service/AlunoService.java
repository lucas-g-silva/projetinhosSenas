package com.psii.professor_aluno_app.service;

import java.util.List;

import com.psii.professor_aluno_app.model.Aluno;
import com.psii.professor_aluno_app.repository.AlunoRepository;

public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}

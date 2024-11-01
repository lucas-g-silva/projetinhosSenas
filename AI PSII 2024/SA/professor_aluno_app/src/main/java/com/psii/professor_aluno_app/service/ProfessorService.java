package com.psii.professor_aluno_app.service;

import java.util.List;

import com.psii.professor_aluno_app.model.Professor;
import com.psii.professor_aluno_app.repository.ProfessorRepository;

public class ProfessorService {
    private ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor save(Professor professor){
        return professorRepository.save(professor);
    }
}

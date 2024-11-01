package com.psii.professor_aluno_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psii.professor_aluno_app.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
}

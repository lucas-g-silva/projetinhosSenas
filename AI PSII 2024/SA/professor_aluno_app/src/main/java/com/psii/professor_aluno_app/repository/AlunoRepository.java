package com.psii.professor_aluno_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psii.professor_aluno_app.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}

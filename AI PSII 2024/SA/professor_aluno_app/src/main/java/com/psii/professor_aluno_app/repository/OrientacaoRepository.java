package com.psii.professor_aluno_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psii.professor_aluno_app.model.Orientacao;

public interface OrientacaoRepository extends JpaRepository<Orientacao, Long>{
    
}

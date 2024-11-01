package com.psii.professor_aluno_app.service;

import java.util.List;

import com.psii.professor_aluno_app.model.Orientacao;
import com.psii.professor_aluno_app.repository.OrientacaoRepository;

public class OrientacaoService {
    private OrientacaoRepository orientacaoRepository;

    public OrientacaoService(OrientacaoRepository orientacaoRepository) {
        this.orientacaoRepository = orientacaoRepository;
    }

    public List<Orientacao> findAll() {
        return orientacaoRepository.findAll();
    }

    public Orientacao save(Orientacao orientacao){
        return orientacaoRepository.save(orientacao);
    }
}

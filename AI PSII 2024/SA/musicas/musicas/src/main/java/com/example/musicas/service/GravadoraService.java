package com.example.musicas.service;

import org.springframework.stereotype.Service;

import com.example.musicas.model.Gravadora;
import com.example.musicas.repository.GravadoraRepository;

import java.util.List;

@Service
public class GravadoraService {
    private final GravadoraRepository gravadoraRepository;

    public GravadoraService(GravadoraRepository gravadoraRepository) {
        this.gravadoraRepository = gravadoraRepository;
    }

    public List<Gravadora> findAll() {
        return gravadoraRepository.findAll();
    }

    public Gravadora save(Gravadora gravadora) {
        return gravadoraRepository.save(gravadora);
    }
}

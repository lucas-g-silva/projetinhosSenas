package com.example.musicas.service;

import org.springframework.stereotype.Service;

import com.example.musicas.model.Artista;
import com.example.musicas.repository.ArtistaRepository;

import java.util.List;

@Service
public class ArtistaService {
    private final ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public List<Artista> findAll() {
        return artistaRepository.findAll();
    }

    public Artista save(Artista artista) {
        return artistaRepository.save(artista);
    }
}

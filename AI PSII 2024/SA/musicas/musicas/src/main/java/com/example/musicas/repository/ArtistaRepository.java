package com.example.musicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.musicas.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}

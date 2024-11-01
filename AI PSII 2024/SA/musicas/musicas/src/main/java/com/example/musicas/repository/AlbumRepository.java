package com.example.musicas.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.musicas.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}

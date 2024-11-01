package com.example.musicas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.musicas.model.Album;
import com.example.musicas.repository.AlbumRepository;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Album save(Album album) {
        return albumRepository.save(album);
    }
}

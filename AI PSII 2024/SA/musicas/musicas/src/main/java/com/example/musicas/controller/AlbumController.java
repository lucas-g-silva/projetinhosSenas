package com.example.musicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.musicas.model.Album;
import com.example.musicas.service.AlbumService;
import com.example.musicas.service.ArtistaService;
import com.example.musicas.service.GravadoraService;

import java.util.List;

@Controller
@RequestMapping("/albuns")
public class AlbumController {
    private final AlbumService albumService;
    private final ArtistaService artistaService;
    private final GravadoraService gravadoraService;

    public AlbumController(AlbumService albumService, ArtistaService artistaService,
            GravadoraService gravadoraService) {
        this.albumService = albumService;
        this.artistaService = artistaService;
        this.gravadoraService = gravadoraService;
    }

    @GetMapping
    public String listarAlbuns(Model model) {
        List<Album> albuns = albumService.findAll();
        model.addAttribute("albuns", albuns);
        model.addAttribute("album", new Album()); // Adicionando um objeto Album vazio
        model.addAttribute("artistas", artistaService.findAll());
        model.addAttribute("gravadoras", gravadoraService.findAll());
        return "album";
    }

    @PostMapping
    public String adicionarAlbum(Album album) {
        albumService.save(album);
        return "redirect:/albuns";
    }
}

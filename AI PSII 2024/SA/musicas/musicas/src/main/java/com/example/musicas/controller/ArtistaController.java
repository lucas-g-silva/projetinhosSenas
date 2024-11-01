package com.example.musicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.musicas.model.Artista;
import com.example.musicas.service.ArtistaService;

import java.util.List;

@Controller
@RequestMapping("/artistas")
public class ArtistaController {
    private final ArtistaService artistaService;

    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @GetMapping
    public String listarArtistas(Model model) {
        List<Artista> artistas = artistaService.findAll();
        model.addAttribute("artistas", artistas);
        model.addAttribute("artista", new Artista()); // Adicione esta linha
        return "artista"; // Certifique-se de que o nome da view está correto
    }

    @PostMapping
    public String adicionarArtista(Artista artista) {
        artistaService.save(artista);
        return "redirect:/artistas";
    }
}

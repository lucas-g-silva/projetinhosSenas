package com.example.musicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.musicas.model.Artista;
import com.example.musicas.model.Gravadora;
import com.example.musicas.service.GravadoraService;

import java.util.List;

@Controller
@RequestMapping("/gravadoras")
public class GravadoraController {
    private final GravadoraService gravadoraService;

    public GravadoraController(GravadoraService gravadoraService) {
        this.gravadoraService = gravadoraService;
    }

    @GetMapping
    public String listarGravadoras(Model model) {
        List<Gravadora> gravadoras = gravadoraService.findAll();
        model.addAttribute("gravadoras", gravadoras);
        model.addAttribute("gravadora", new Gravadora()); // Adicione esta linha
        return "gravadora";
    }

    @PostMapping
    public String adicionarGravadora(Gravadora gravadora) {
        gravadoraService.save(gravadora);
        return "redirect:/gravadoras";
    }
}

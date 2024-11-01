package com.psii.professor_aluno_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.professor_aluno_app.model.Professor;
import com.psii.professor_aluno_app.service.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public String listarProfessores(Model model){
        List<Professor> professores = professorService.findAll();
        model.addAttribute("professores", professores);
        model.addAttribute("professor", new Professor());
        return "professor";
    }

    @PostMapping
    public String adicionarProfessor(Professor professor){
        professorService.save(professor);
        return "redirect:/professores";
    }
}

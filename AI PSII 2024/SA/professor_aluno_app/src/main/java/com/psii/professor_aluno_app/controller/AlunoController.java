package com.psii.professor_aluno_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.professor_aluno_app.model.Aluno;
import com.psii.professor_aluno_app.service.AlunoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public String listarAlunos(Model model){
        List<Aluno> alunos = alunoService.findAll();
        model.addAttribute("alunos", alunos);
        model.addAttribute("aluno", new Aluno());
        return "aluno";
    }

    @PostMapping
    public String adicionarAluno(Aluno aluno){
        alunoService.save(aluno);
        return "redirect:/alunos";
    }
}

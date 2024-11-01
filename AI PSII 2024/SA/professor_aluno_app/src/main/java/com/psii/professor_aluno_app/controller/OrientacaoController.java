package com.psii.professor_aluno_app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.professor_aluno_app.model.Aluno;
import com.psii.professor_aluno_app.model.Orientacao;
import com.psii.professor_aluno_app.model.Professor;
import com.psii.professor_aluno_app.service.AlunoService;
import com.psii.professor_aluno_app.service.OrientacaoService;
import com.psii.professor_aluno_app.service.ProfessorService;

@Controller
@RequestMapping("/orientacoes")
public class OrientacaoController {
    @Autowired
    private OrientacaoService orientacaoService;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public String listarOrientacoes(Model model) {
        List<Orientacao> orientacoes = orientacaoService.findAll();
        List<Aluno> alunos = alunoService.findAll();
        List<Aluno> alunosDisponiveis = new ArrayList<>();
        List<Professor> professores = professorService.findAll();

        alunos.forEach(aluno -> {
            if (aluno.getOrientacao() == null) {
                alunosDisponiveis.add(aluno);
            }
        });

        model.addAttribute("orientacoes", orientacoes);
        model.addAttribute("alunos", alunosDisponiveis);
        model.addAttribute("professores", professores);

        return "orientacao";
    }

    @PostMapping
    public String adicionarOrientacao(Orientacao orientacao){
        orientacaoService.save(orientacao);
        return "redirect:/orientacoes";
    }
}

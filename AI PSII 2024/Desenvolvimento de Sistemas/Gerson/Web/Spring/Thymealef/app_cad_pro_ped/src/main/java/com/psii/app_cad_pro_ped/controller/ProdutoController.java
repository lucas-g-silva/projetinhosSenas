package com.psii.app_cad_pro_ped.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.app_cad_pro_ped.model.Produto;
import com.psii.app_cad_pro_ped.repository.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        model.addAttribute("pedidos", new ArrayList<>());
        return "index";
    }

    @PostMapping
    public String salvarProduto(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/produto";
    }
}

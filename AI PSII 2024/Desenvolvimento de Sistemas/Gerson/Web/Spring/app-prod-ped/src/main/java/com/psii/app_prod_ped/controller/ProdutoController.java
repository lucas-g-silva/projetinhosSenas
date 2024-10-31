package com.psii.app_prod_ped.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.psii.app_prod_ped.model.Produto;
import com.psii.app_prod_ped.repository.ProdutoRepository;

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
    public String salvarProduto(@ModelAttribute Produto produto){
        produtoRepository.save(produto);
        return "redirect:/produto";
    }
}

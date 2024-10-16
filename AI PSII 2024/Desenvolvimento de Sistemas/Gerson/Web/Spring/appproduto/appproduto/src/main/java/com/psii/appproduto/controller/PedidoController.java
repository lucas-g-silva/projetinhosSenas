package com.psii.appproduto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.appproduto.model.Pedido;
import com.psii.appproduto.repository.PedidoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/pedidos/")
    public String showForm(Model model) {
        model.addAttribute("pedidos", pedidoRepository.findAll());
        model.addAttribute("novoPedido", new Pedido());
        return "index.html";
    }

    @PostMapping("/pedidos/salvar")
    public String salvarPedido(@ModelAttribute Pedido pedido) {
        pedidoRepository.save(pedido);
        return "redirect:/";
    }
}

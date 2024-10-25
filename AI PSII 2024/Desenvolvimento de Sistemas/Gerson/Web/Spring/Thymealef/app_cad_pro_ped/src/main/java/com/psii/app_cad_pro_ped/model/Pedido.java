package com.psii.app_cad_pro_ped.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private Long id;
    private LocalDate dataPedido;

    @ManyToOne
    @JoinColumn(name = "id_produto")

    private Produto produto;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}

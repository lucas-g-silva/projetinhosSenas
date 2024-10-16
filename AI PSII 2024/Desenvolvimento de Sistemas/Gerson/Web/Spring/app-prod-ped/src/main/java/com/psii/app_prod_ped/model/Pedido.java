package com.psii.app_prod_ped.model;


import jakarta.persistence.*;
import java.time.LocalDate;

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

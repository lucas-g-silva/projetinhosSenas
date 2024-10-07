/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author lucas-gabreil_silva
 */
public class Pedido {
    private int cod;
    private Date dataEmissao;
    private int idCliente;
    private List<Integer> idProdutos;

    public Pedido(int cod, Date dataEmissao, int idCliente, List<Integer> idProdutos) {
        this.cod = cod;
        this.dataEmissao = dataEmissao;
        this.idCliente = idCliente;
        this.idProdutos = idProdutos;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<Integer> getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(List<Integer> idProdutos) {
        this.idProdutos = idProdutos;
    }
    
    
}

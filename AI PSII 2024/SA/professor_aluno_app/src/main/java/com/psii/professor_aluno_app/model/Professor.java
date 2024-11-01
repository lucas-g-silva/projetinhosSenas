package com.psii.professor_aluno_app.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date data_nasc;
    private double salario;
    private String disciplina;

    @OneToMany(mappedBy = "professor")
    private List<Orientacao> orientacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public List<Orientacao> getOrientacoes() {
        return orientacoes;
    }

    public void setOrientacoes(List<Orientacao> orientacoes) {
        this.orientacoes = orientacoes;
    }
}

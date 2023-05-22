package com.example.ap2_dac.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Agressor {
    @Column
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nome;
    @Column
    private Character sexo;
    @Column
    private Integer idade;
    @Column
    private String grauParentesco;
    @Column
    private String profissao;
    @Column
    private String raca;
    @Column
    private String identidadeGenero;
    @Column
    private String orientacaoSexual;
    @Column
    private String escolaridade;
    @Column
    @NotNull
    private String incidente;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> violacao;

    public Agressor(String nome, Character sexo, Integer idade, String grauParentesco, String profissao, String raca, String identidadeGenero, String orientacaoSexual, String escolaridade, String incidente, ArrayList<String> violacao) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.grauParentesco = grauParentesco;
        this.profissao = profissao;
        this.raca = raca;
        this.identidadeGenero = identidadeGenero;
        this.orientacaoSexual = orientacaoSexual;
        this.escolaridade = escolaridade;
        this.incidente = incidente;
        this.violacao = violacao;
    }

    public Agressor() {

    }
}

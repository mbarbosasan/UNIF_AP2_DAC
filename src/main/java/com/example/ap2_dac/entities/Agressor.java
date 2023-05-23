package com.example.ap2_dac.entities;

import javax.persistence.*;

@Entity
@Table
public class Agressor {
    @Id
    @GeneratedValue
    @Column
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
    private String ocupacao;
    @Column
    private String raca;
    @Column
    private String identidadeGenero;
    @Column
    private String orientacaoSexual;
    @Column
    private String orientacaoSexualOutro;
    @Column
    private String escolaridade;

    public Agressor() {
    }

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

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getIdentidadeGenero() {
        return identidadeGenero;
    }

    public void setIdentidadeGenero(String identidadeGenero) {
        this.identidadeGenero = identidadeGenero;
    }

    public String getOrientacaoSexual() {
        return orientacaoSexual;
    }

    public void setOrientacaoSexual(String orientacaoSexual) {
        this.orientacaoSexual = orientacaoSexual;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getOrientacaoSexualOutro() {
        return orientacaoSexualOutro;
    }

    public void setOrientacaoSexualOutro(String orientacaoSexualOutro) {
        this.orientacaoSexualOutro = orientacaoSexualOutro;
    }
}


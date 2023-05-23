package com.example.ap2_dac.entities;

import javax.persistence.*;

@Entity
@Table
public class Vitima {
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
    private String serieTurno;
    @Column
    private String endereco;

    public Vitima() {
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

    public String getSerieTurno() {
        return serieTurno;
    }

    public void setSerieTurno(String serieTurno) {
        this.serieTurno = serieTurno;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

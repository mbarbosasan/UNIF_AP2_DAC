package com.example.ap2_dac.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vitima extends Usuario{
    @Id
    @Column
    @GeneratedValue()
    private Long id;
    @Column
    private String nome;
    @Column
    private Integer idade;
    @Column
    private Character sexo;
    @Column
    private String serieTurno;
    @Column
    private String endereco;

    public Vitima(String usuario, String senha, String email) {
        super(usuario, senha, email);
    }

    public Vitima() {

    }
}

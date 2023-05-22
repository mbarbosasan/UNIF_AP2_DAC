package com.example.ap2_dac.entities;

import javax.persistence.*;

@Entity
@Table
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String usuarioLogin;
    @Column
    private String senha;

    public Usuario(String user, String senha, String email) {
        this.usuarioLogin = user;
        this.senha = senha;
    }

    public Usuario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String user) {
        this.usuarioLogin = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}


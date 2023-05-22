package com.example.ap2_dac.entities;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Column(name = "id_usuario")
    @GeneratedValue
    @Id
    private Long id;
    @Column
    @NotNull
    private String user;
    @Column
    @NotNull
    private String senha;
    @Column
    private String email;

    public Usuario(String user, String senha, String email) {
        this.user = user;
        this.senha = senha;
        this.email = email;
    }

    public Usuario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


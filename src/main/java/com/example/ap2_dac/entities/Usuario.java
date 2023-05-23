package com.example.ap2_dac.entities;

import javax.persistence.*;
import java.util.Date;

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
    @Column
    private String email;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}


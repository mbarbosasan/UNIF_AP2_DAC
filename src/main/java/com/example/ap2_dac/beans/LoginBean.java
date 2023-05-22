package com.example.ap2_dac.beans;

import com.example.ap2_dac.daos.LoginDAO;
import com.example.ap2_dac.entities.Usuario;
import com.example.ap2_dac.util.MessagesUtil;

import javax.faces.bean.ManagedBean;
import javax.servlet.annotation.WebServlet;
@ManagedBean
@WebServlet(name = "loginBean", value = "/loginBean")
public class LoginBean {

    Usuario usuario = new Usuario();

    public void save() {
        try {
            System.out.println("LOGIN:" + usuario.getUsuarioLogin() + " SENHA:" + usuario.getSenha());
            Usuario usuarioExiste = LoginDAO.getUsuario(usuario.getUsuarioLogin(), usuario.getSenha());
            if (usuarioExiste != null) {
                this.usuario = usuarioExiste;
            }
        } catch (Exception e) {
            MessagesUtil.errorMessage("Usuário não encontrado, cadastre-se para acessar o sistema.");
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

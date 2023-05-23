package com.example.ap2_dac.beans;

import com.example.ap2_dac.daos.LoginDAO;
import com.example.ap2_dac.entities.Usuario;
import com.example.ap2_dac.exceptions.UsuarioExistente;
import com.example.ap2_dac.util.MessagesUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.annotation.WebServlet;
@ManagedBean
@WebServlet(name = "loginBean", value = "/loginBean")
public class LoginBean {

    Usuario usuario = new Usuario();

    public void save() {
        if (validaCadastro()) {
            try {
                LoginDAO.save(usuario);
                MessagesUtil.successMessage("Usuário cadastrado com sucesso, <a href=\"index.xhtml\">faça o login aqui.</a>");
            } catch (UsuarioExistente e) {
                MessagesUtil.errorMessage(e.getMessage());
            }
        } else {
            MessagesUtil.errorMessage("Alguns campos não foram preenchidos, por favor, preencha todos os campos.");
        }
    }

    public void login() {
        try {
            Usuario usuarioExiste = LoginDAO.getUsuario(usuario.getUsuarioLogin(), usuario.getSenha());
            MessagesUtil.successMessage("Usuário encontrado.");
        } catch (Exception e) {
            MessagesUtil.errorMessage("Nome de usuário/email/senha incorretos ou usuário não existente, cadastre-se para acessar o sistema.");
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Boolean validaCadastro() {
        return !usuario.getUsuarioLogin().isEmpty() && !usuario.getSenha().isEmpty() && !usuario.getEmail().isEmpty();
    }

    public void limparCampos() {
        this.usuario = new Usuario();
    }
}

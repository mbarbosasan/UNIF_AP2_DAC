package com.example.ap2_dac.beans;

import com.example.ap2_dac.daos.LoginDAO;
import com.example.ap2_dac.entities.Usuario;
import com.example.ap2_dac.exceptions.UsuarioExistente;
import com.example.ap2_dac.util.MessagesUtil;
import org.primefaces.event.RowEditEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@WebServlet(name = "loginBean", value = "/loginBean")
public class LoginBean {

    Usuario usuario = new Usuario();
    List<Usuario> listUsuarios = new ArrayList<>();

    Usuario usuarioSelected = new Usuario();

    public void deleteUsuario() {
        try {
            LoginDAO.delete(this.usuarioSelected);
            MessagesUtil.successMessage("Usuário deletado com sucesso.");
        } catch (Exception e) {
            MessagesUtil.errorMessage("Erro ao deletar usuário. Stacktrace:" +  e.getMessage());
        }
    }

    public void updateUsuario(RowEditEvent event) {
        try {
            Usuario usuario = (Usuario) event.getObject();
            LoginDAO.update(usuario);
            MessagesUtil.successMessage("Usuário atualizado com sucesso.");
        } catch (Exception e) {
            MessagesUtil.errorMessage("Erro ao atualizar usuário. Stacktrace:" +  e.getMessage());
        }
    }

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

    public String login() {
        try {
            Usuario usuarioExiste = LoginDAO.getUsuario(usuario.getUsuarioLogin(), usuario.getSenha());
            return "lista_incidentes?faces-redirect=true";
        } catch (Exception e) {
            MessagesUtil.errorMessage("Nome de usuário/email/senha incorretos ou usuário não existente, cadastre-se para acessar o sistema.");
            return null;
        }
    }

    public List<Usuario> getListUsuarios() {
        if (this.listUsuarios.size() != LoginDAO.getAllUsuarios().size()) {
            this.listUsuarios = LoginDAO.getAllUsuarios();
            return this.listUsuarios;
        } else {
            return this.listUsuarios;
        }
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Usuario getUsuarioSelected() {
        return usuarioSelected;
    }

    public void setUsuarioSelected(Usuario usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }

    public Boolean validaCadastro() {
        return !usuario.getUsuarioLogin().isEmpty() && !usuario.getSenha().isEmpty() && !usuario.getEmail().isEmpty();
    }

    public void limparCampos() {
        this.usuario = new Usuario();
    }
}

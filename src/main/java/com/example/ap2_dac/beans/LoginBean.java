package com.example.ap2_dac.beans;

import com.example.ap2_dac.entities.Usuario;

import javax.faces.bean.ManagedBean;
import javax.servlet.annotation.WebServlet;

@ManagedBean
@WebServlet(name = "loginBean", value = "/loginBean")
public class LoginBean {

    Usuario usuario = new Usuario();

    public void save() {

    }

}

package com.example.ap2_dac.daos;

import com.example.ap2_dac.entities.Usuario;
import com.example.ap2_dac.util.JPAUtil;

import javax.persistence.EntityManager;

public class UsuarioDAO {
    public static void save(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public static Usuario getUsuario(String usuario, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        Usuario usuarioEncontrado = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha", Usuario.class)
                .setParameter("usuario", usuario)
                .setParameter("senha", senha)
                .getSingleResult();
        em.close();
        return usuarioEncontrado;
    }
}

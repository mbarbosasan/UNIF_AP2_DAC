package com.example.ap2_dac.daos;

import com.example.ap2_dac.entities.Usuario;
import com.example.ap2_dac.exceptions.UsuarioExistente;
import com.example.ap2_dac.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class LoginDAO {
    public static void save(Usuario usuario) throws UsuarioExistente {
        if (usuarioExiste(usuario)) {
            throw new UsuarioExistente("Já existe um usuário cadastro com esse login ou email, verifique os dados e tente novamente.");
        }
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public static Usuario getUsuario(String usuario, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        if (usuario.contains("@")) {
            Usuario usuarioEncontrado = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :usuario AND u.senha = :senha", Usuario.class)
                    .setParameter("usuario", usuario)
                    .setParameter("senha", senha)
                    .getSingleResult();
            em.close();
            return usuarioEncontrado;
        } else {
            Usuario usuarioEncontrado = em.createQuery("SELECT u FROM Usuario u WHERE u.usuarioLogin = :usuario AND u.senha = :senha", Usuario.class)
                    .setParameter("usuario", usuario)
                    .setParameter("senha", senha)
                    .getSingleResult();
            em.close();
            return usuarioEncontrado;
        }
    }

    public static Boolean usuarioExiste(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(u) FROM Usuario u WHERE u.usuarioLogin = :usuarioLogin OR u.email = :email", Long.class);
        query.setParameter("usuarioLogin", usuario.getUsuarioLogin());
        query.setParameter("email", usuario.getEmail());

        return query.getSingleResult() > 0;
    }
}

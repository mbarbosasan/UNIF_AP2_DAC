package com.example.ap2_dac.daos;

import com.example.ap2_dac.entities.Incidente;
import com.example.ap2_dac.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;

public class IncidenteDAO {


    public static Object getIncidentes() {
       EntityManager entityManager = JPAUtil.getEntityManager();
        TypedQuery<Incidente> query = entityManager.createQuery("SELECT i FROM Incidente i JOIN FETCH i.vitima JOIN FETCH i.agressor", Incidente.class);
        return query.getSingleResult();
    }

    public static void save(Incidente incidente) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        incidente.setDataCadastro(new Date());
        em.persist(incidente);
        em.getTransaction().commit();
        em.close();
    }
}

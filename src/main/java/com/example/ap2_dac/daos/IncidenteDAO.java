package com.example.ap2_dac.daos;

import com.example.ap2_dac.entities.Incidente;
import com.example.ap2_dac.util.JPAUtil;

import javax.persistence.EntityManager;

public class IncidenteDAO {


    public static void getIncidentes() {
    }

    public static void save(Incidente incidente) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(incidente);
        em.getTransaction().commit();
        em.close();
    }
}

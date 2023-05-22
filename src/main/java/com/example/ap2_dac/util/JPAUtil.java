package com.example.ap2_dac.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgresUnit");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}

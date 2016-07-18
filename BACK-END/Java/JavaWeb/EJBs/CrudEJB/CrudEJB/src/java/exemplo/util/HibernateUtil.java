/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Maikon
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).buildMetadata().buildSessionFactory();

        } catch (Throwable e) {
            System.err.println("Falha ao criar SessionFactory: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

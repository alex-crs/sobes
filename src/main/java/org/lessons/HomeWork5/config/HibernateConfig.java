package org.lessons.HomeWork5.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lessons.HomeWork5.entities.Student;

public class HibernateConfig implements Config {
    private static HibernateConfig config;

    private final SessionFactory sessionFactory;

    private HibernateConfig() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static synchronized HibernateConfig getHibernateConfig() {
        if (config == null) {
            config = new HibernateConfig();
            return config;
        } else {
            return config;
        }
    }
}

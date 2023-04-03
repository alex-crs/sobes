package org.lessons.HomeWork5.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lessons.HomeWork5.entities.Student;

public class HibernateConfig {
    public static SessionFactory getSessionFactory(){
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }
}

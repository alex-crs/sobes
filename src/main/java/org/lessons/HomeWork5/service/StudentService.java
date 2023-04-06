package org.lessons.HomeWork5.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lessons.HomeWork5.config.HibernateConfig;
import org.lessons.HomeWork5.entities.Student;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentService {
    private Session session = null;
    private final SessionFactory sessionFactory;

    public StudentService() {
        sessionFactory = HibernateConfig.getHibernateConfig().getSessionFactory();
    }

    public List<Student> getAllStudents() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Student> studentList = castList(Student.class, session.createQuery("from Student")
                .getResultList());
        session.getTransaction().commit();
        return studentList;
    }

    public Student getStudentByName(String name) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = null;
        try {
            student = (Student) session.createQuery("from Student where name=:name")
                    .setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            session.getTransaction().commit();
            return null;
        }
        session.getTransaction().commit();
        return student;
    }

    public int deleteById(int id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = null;
        try {
            student = (Student) session.createQuery("from Student where id=:id")
                    .setParameter("id", id).getSingleResult();
            session.remove(student);
        } catch (NoResultException e) {
            session.getTransaction().commit();
            return -1;
        }
        session.getTransaction().commit();
        return 1;
    }

    public Student getStudentById(int id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = null;
        try {
            student = (Student) session.createQuery("from Student where id=:id")
                    .setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            session.getTransaction().commit();
            return null;
        }
        session.getTransaction().commit();
        return student;
    }

    public int addStudent(String name, String mark) {
        Student student = new Student();
        student.setName(name);
        student.setMark(mark);
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            session.save(student);
        } catch (Exception e) {
            session.getTransaction().commit();
            return -1;
        }
        session.getTransaction().commit();
        return 1;
    }

    public int changeStudentById(int id, String newName, String newMark) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = null;
        try {
            student = (Student) session.createQuery("from Student where id=:id")
                    .setParameter("id", id).getSingleResult();

            if (!newName.equals("false")) {
                student.setName(newName);
            }
            if (!newMark.equals("false")) {
                student.setMark(newMark);
            }
            session.save(student);
        } catch (Exception e) {
            session.getTransaction().commit();
            return -1;
        }
        session.getTransaction().commit();
        return 1;
    }


    public <T> List<T> castList(Class<? extends T> clazz, Collection<?> rawCollection) {
        try {
            return rawCollection.stream().map((Function<Object, T>) clazz::cast).collect(Collectors.toList());
        } catch (ClassCastException e) {
            return Collections.emptyList();
        }
    }
}

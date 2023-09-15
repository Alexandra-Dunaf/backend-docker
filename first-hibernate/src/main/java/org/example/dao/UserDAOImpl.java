package org.example.dao;

import org.example.HibernateUtil;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;

public class UserDAOImpl implements CommonDAO{

    @Override
    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("from User", User.class);
        List<User> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public List<User> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("from User where email=:email", User.class);
        query.setParameter("email", email);
        List<User> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public User get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(User.class, id);
    }

    @Override
    public void update(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.remove(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
        session.close();
    }
}

package org.example.dao.impl;

import org.example.HibernateUtil;
import org.example.dao.interfaces.objects.PriorityDAO;
import org.example.entity.Priority;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PriorityDAOImpl implements PriorityDAO {

    @Override
    public List<Priority> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Priority> query = session.createQuery("FROM Priority", Priority.class);
        List<Priority> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Priority> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Priority> query = session.createQuery("from Priority p where p.user.email like :email", Priority.class);
        query.setParameter("email", "%"+email+"%");
        List<Priority> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public Priority get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Priority user = session.get(Priority.class, id);
        session.close();
        return user;
    }

    @Override
    public void update(Priority obj) {
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
        Priority u = new Priority();
        u.setId(id);
        session.remove(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Priority obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
        session.close();
    }


}

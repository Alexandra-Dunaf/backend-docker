package org.example.dao.impl;

import org.example.HibernateUtil;
import org.example.entity.Task;
import org.example.dao.interfaces.objects.TaskDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TaskDAOImpl implements TaskDAO {


    @Override
    public List<Task> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Task> query = session.createQuery("from Task", Task.class);
        List<Task> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Task> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Task> query = session.createQuery("from Task t where t.user.email like :email", Task.class);
        query.setParameter("email", "%"+email+"%");
        List<Task> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public Task get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Task.class, id);
    }

    @Override
    public void update(Task obj) {
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
        Task Task = new Task();
        Task.setId(id);
        session.remove(Task);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Task obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
        session.close();
    }



    @Override
    public List<Task> find(boolean completed, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Task> query = session.createQuery("from Task t where t.user.email like :email and t.completed = :completed", Task.class);
        query.setParameter("email", "%"+email+"%");
        query.setParameter("completed", completed);
        List<Task> list = query.getResultList();
        session.close();
        return list;
    }
}

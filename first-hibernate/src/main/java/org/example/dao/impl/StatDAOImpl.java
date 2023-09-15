package org.example.dao.impl;

import org.example.HibernateUtil;
import org.example.dao.interfaces.objects.StatDAO;
import org.example.entity.Stat;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class StatDAOImpl implements StatDAO {

    @Override
    public Stat getByUser(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Stat> query = session.createQuery("from Stat where user.email like :email", Stat.class);
        query.setParameter("email", "%" + email + "%");
        Stat stat = query.uniqueResult();
        session.close();
        return stat;
    }

    @Override
    public Stat getByUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Stat> query = session.createQuery("from Stat where user.email like :email", Stat.class);
        query.setParameter("email", "%" + user.getEmail() + "%");
        Stat stat = query.uniqueResult();
        session.close();
        return stat;
    }
}


package org.example;

import org.hibernate.Session;
import org.hibernate.engine.spi.SessionLazyDelegator;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
        HibernateUtil.close();
    }
}
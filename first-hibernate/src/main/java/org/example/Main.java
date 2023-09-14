package org.example;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionLazyDelegator;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        //открыть транзакцию
        session.getTransaction().begin();
        //создать нового пользователя
        User user = new User();
        user.setEmail("sas1fsdgdrt@yan.ru");
        user.setUsername("Sashabdxhdrm");
        user.setPassword("cxnvsjd");
        //передать пользователя в контейнер session
        session.save(user);
        //закрыть транзакцию и сохранить изменения (транзакция завершается)
        session.getTransaction().commit();

        session.close();
        HibernateUtil.close();
    }
}
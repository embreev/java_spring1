package ru.breev.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SessionService {
    SessionFactory factory;
    Session session;

    public SessionService() {
        factory = new Configuration()
                .configure("configs/common/hibernate.cfg.xml")
                .buildSessionFactory();

        session = null;
    }

    public Session getCurrentSession() {
        session = factory.getCurrentSession();
        return session;
    }

    public void closeSession () {
        factory.close();
    }
}

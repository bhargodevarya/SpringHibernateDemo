package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 433132 on 6/8/2016.
 */

@Transactional
public abstract class AbstractDao<E> {

    @Autowired
    protected SessionFactory sessionFactory;

    //@Transactional
    public void save(E e) {
        saveEntity(e);
    }

    private void saveEntity(E e) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(e);
    }
}

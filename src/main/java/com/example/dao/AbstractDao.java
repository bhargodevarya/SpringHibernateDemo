package com.example.dao;

import com.example.service.BaseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by 433132 on 6/8/2016.
 */
public class AbstractDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Transactional
    public void save(T e) {
        saveEntity(e);
    }

    //@Transactional
    private void saveEntity(T e) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            System.out.println("Session is >>>>>>>>>>>>>>>>> " + session);
        } catch(Exception e1) {
            //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> There has been an exception");
            //session = sessionFactory.openSession();
        }
        //Transaction transaction = session.beginTransaction();
        session.save(e);
        //session.close();
    }

    @Transactional
    public T getEntity(Class<T> clazz, Serializable id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(">>>>>>>>>>>>>>>> " + session.isConnected() + " " + session.isOpen());
        //Transaction transaction = session.beginTransaction();
        return session.load(clazz,id);
    }

    @PostConstruct
    public void register() throws ClassNotFoundException {
        BaseService.getDaoMap().put(((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]),this);
        BaseService.getDaoMap().entrySet().stream().forEach(System.out::println);
    }
}

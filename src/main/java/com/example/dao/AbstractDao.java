package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 433132 on 6/8/2016.
 */

@Transactional
public abstract class AbstractDao {

    @Autowired
    @Qualifier(value = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    protected HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
}

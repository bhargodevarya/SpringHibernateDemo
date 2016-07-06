package com.example.dao;

import com.example.model.School;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 433132 on 6/28/2016.
 */
@Repository
@Transactional
public class SchoolDao extends AbstractDao<School> {

    //@Transactional
    public void saveSchool(School school) {
        save(school);
    }

    //@Transactional
    public School getSchool(int id) {
        School school = getEntity(School.class,id);
        Hibernate.initialize(school.getStudents());
        return school;
    }
}

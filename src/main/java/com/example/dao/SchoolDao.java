package com.example.dao;

import com.example.model.School;

/**
 * Created by 433132 on 6/28/2016.
 */
public class SchoolDao extends AbstractDao<School> {

    public void saveSchool(School school) {
        save(school);
    }
}

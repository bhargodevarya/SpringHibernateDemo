package com.example.service;

import com.example.dao.SchoolDao;
import com.example.model.School;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by 433132 on 6/29/2016.
 */
@Component
public class SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    public School createSchool(String name) {
        School school = new School();
        school.setName(name);
        schoolDao.save(school);
        return school;
    }

    public Set<Student> getStudentsForSchoolId(int id) {
        return schoolDao.getSchool(id).getStudents();
    }
}

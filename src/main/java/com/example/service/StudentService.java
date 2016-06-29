package com.example.service;

import com.example.dao.StudentDao;
import com.example.model.School;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 433132 on 6/29/2016.
 */
@Component
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student createStudent(String name, School school) {
        Student student = new Student();
        student.setName(name);
        student.setSchool(school);
        studentDao.save(student);
        return student;
    }
}

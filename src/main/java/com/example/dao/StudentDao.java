package com.example.dao;

import com.example.model.Student;

/**
 * Created by 433132 on 6/28/2016.
 */
public class StudentDao extends AbstractDao<Student> {

    public void saveStudent(Student student) {
        save(student);
    }
}

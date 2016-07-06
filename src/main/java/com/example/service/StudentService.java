package com.example.service;

import com.example.dao.StudentDao;
import com.example.model.School;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 433132 on 6/29/2016.
 */
@Component
@Transactional
public class StudentService extends BaseService<Student>{

    @Autowired
    private StudentDao studentDao;

    //@Transactional
    public Student createStudent(String name, School school) {
        Student student = new Student();
        student.setName(name);
        student.setSchool(school);
        create(student);
        return student;
    }

    //@Transactional
    public List<Student> getStudentByName(String name) {
        return studentDao.getStudents(name);
    }

    public Student getStudentById(Serializable id) {
        return studentDao.getEntity(Student.class, id);
    }
}

package com.example.dao;

import com.example.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 433132 on 6/28/2016.
 */
@Component
public class StudentDao extends AbstractDao<Student> {

    @Transactional
    public void saveStudent(Student student) {
        save(student);
    }
}

package com.example.dao;

import com.example.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 433132 on 6/28/2016.
 */
@Component
public class StudentDao extends AbstractDao<Student> {

    @Transactional
    public void saveStudent(Student student) {
        save(student);
    }

    @Transactional
    public List<Student> getStudents(String name) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.eq("name",name));
        return criteria.list();
    }
}

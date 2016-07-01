package com.example.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 433132 on 6/28/2016.
 */
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private int id;

    private String name;

    /*each student instance needs to be allocated a school.
    * because of mappedBy, you dont need to assign a school instance all the students.
    * BUT you need to save both of them separately*/
    @OneToMany(mappedBy = "school"/*, cascade = CascadeType.ALL*/)
    private Set<Student> students;

    public School() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}

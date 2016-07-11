package com.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by barya on 7/11/16.
 */
@XmlRootElement
public class Person {

    //@XmlElement
    private String name;
    //@XmlElement
    private int age;
    private String email;

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }
}

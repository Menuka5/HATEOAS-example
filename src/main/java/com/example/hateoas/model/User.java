package com.example.hateoas.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by hsenid on 8/15/18.
 */
public class User extends ResourceSupport {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

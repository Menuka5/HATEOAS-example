package com.example.hateoas.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by hsenid on 8/15/18.
 */
public class Dependent extends ResourceSupport {

    private String parent;
    private String name;
    private int age;

    public Dependent(String parent, String name, int age) {
        this.parent = parent;
        this.name = name;
        this.age = age;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
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

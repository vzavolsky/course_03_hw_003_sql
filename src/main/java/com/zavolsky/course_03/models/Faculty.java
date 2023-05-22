package com.zavolsky.course_03.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculties", schema = "public")
public class Faculty {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    String color;

    public Faculty(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Faculty() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

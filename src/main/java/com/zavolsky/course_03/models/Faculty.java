package com.zavolsky.course_03.models;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    String color;

    @OneToMany(mappedBy = "faculty")
    private Collection<Student> students;

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

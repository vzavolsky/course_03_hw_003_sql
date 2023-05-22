package com.zavolsky.course_03.services;

import com.zavolsky.course_03.models.Student;

import java.util.Collection;
import java.util.Map;

public interface StudentService {

    final Map<Long, Student> students = null;

    Student add(String name, int age);

    Collection<Student> getAll();

    Student get(Long id);

    Student update(Long id, String name, int age);

    void remove(Long id);

    Collection<Student> getAllByAge(Integer age);
}

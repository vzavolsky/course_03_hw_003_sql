package com.zavolsky.course_03.repositories;

import com.zavolsky.course_03.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findAllByAge(Integer age);

    Collection<Student> findByName(String name);

    Collection<Student> findByAgeBetween(Integer min, Integer max);

    @Query(value = "SELECT * FROM students WHERE age >= 13 AND age <= 20", nativeQuery = true)
    Collection<Student> findAllByAgeInterval();

    @Query(value = "SELECT name FROM students;", nativeQuery = true)
    ArrayList<String> findAllNamesOnly();

    Collection<Student> findAllByNameContains(String ch);

    @Query(value = "SELECT * FROM students WHERE age < id", nativeQuery = true)
    Collection<Student> findAllWhereAgeLessId();

    @Query(value = "SELECT * FROM students ORDER BY age", nativeQuery = true)
    Collection<Student> findAllOrderByAge();
}

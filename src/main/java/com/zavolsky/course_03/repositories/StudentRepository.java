package com.zavolsky.course_03.repositories;

import com.zavolsky.course_03.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findAllByAge(Integer age);

    Collection<Student> findByName(String name);

    Collection<Student> findByAgeBetween(Integer min, Integer max);

    @Query(value = "SELECT * FROM students WHERE age >= 13 AND age <= 20", nativeQuery = true)
    Collection<Student> findAllByAgeInterval();

    @Query(value = "SELECT name FROM students;", nativeQuery = true)
    ArrayList<String> findAllNamesOnly();

    @Query(value = "SELECT * FROM students WHERE age < id", nativeQuery = true)
    Collection<Student> findAllWhereAgeLessId();

    @Query(value = "SELECT * FROM students ORDER BY age", nativeQuery = true)
    Collection<Student> findAllOrderByAge();

    @Query(value = "SELECT s.id, s.name, s.age FROM students as s WHERE s.name LIKE '%:ch%'", nativeQuery = true)
    Collection<Student> findAllStudentsNamesConsistsCh(String ch);

    List<Student> findAllByFaculty_Id(Long id);

}

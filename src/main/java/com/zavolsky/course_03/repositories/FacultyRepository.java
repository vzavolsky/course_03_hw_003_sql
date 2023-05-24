package com.zavolsky.course_03.repositories;

import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    @Query(value = "SELECT * FROM faculties WHERE color = :color", nativeQuery = true)
    Collection<Faculty> findAllByColor(@Param("color") final String color);

    /*@Query(value = "SELECT f FROM Student s, Faculty f WHERE s.faculty_id = f.id AND s.id = :studentId")
    ArrayList<Faculty> getFacultyByStudentId(Long studentId);*/

}

package com.zavolsky.course_03.repositories;

import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    @Query(value = "SELECT f FROM Faculty f WHERE f.color = :color")
    Collection<Faculty> findAllByColor(@Param("color") final String color);

}

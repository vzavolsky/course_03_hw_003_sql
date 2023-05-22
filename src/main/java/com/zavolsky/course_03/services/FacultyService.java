package com.zavolsky.course_03.services;

import com.zavolsky.course_03.models.Faculty;

import java.util.Collection;
import java.util.Map;

public interface FacultyService {

    final Map<Long, Faculty> faculties = null;

    public Faculty add(String name, String color);

    public Collection<Faculty> getAll();

    public Faculty get(Long id);

    public Faculty update(Long id, String name, String color);

    public Faculty remove(Long id);

    Collection<Faculty> getAllByColor(String color);

}

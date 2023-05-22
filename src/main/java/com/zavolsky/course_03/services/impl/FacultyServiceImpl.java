package com.zavolsky.course_03.services.impl;

import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.repositories.FacultyRepository;
import com.zavolsky.course_03.services.FacultyService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    Faculty faculty = new Faculty();

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty add(String name, String color) {
        Faculty faculty = new Faculty(name,color);
        facultyRepository.save(faculty);
        return faculty;
    }

    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getAllByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }

    public Faculty get(Long id) {
        return faculties.get(id);
    }

    public Faculty update(Long id, String name, String color) {
        faculties.get(id).setName(name);
        faculties.get(id).setColor(color);
        return faculties.get(id);
    }

    public Faculty remove(Long id) {
        Faculty faculty = faculties.get(id);
        faculties.remove(id);
        return faculty;
    }

}

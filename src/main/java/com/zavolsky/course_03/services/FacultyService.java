package com.zavolsky.course_03.services;

import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getAllByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }

    public Faculty get(Long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty update(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void remove(Faculty faculty) {
        facultyRepository.delete(faculty);
    }

    /*public ArrayList<Faculty> getFacultyByStudentId(Long studentId) {
        return facultyRepository.getFacultyByStudentId(studentId);
    }*/

}

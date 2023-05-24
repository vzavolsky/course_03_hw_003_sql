package com.zavolsky.course_03.services;

import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

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

    public Faculty add(Faculty faculty) {
        faculty.setId(null);
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> get(Long id) {
        return facultyRepository.findById(id);
    }

    public Optional<Faculty> update(Long id, Faculty faculty) {
        return facultyRepository.findById(id)
                .map(f -> {
                    f.setName(faculty.getName());
                    f.setColor(faculty.getColor());
                    return facultyRepository.save(faculty);
                });
    }

    public Optional<Faculty> remove(Long id) {
        return facultyRepository.findById(id)
                .map(faculty -> {
                    facultyRepository.deleteById(id);
                    return faculty;
                });
    }

    public ArrayList<Faculty> getFacultyByStudentId(Long studentId) {
        return facultyRepository.getFacultyByStudentId(studentId);
    }

}

package com.zavolsky.course_03.services;

import com.zavolsky.course_03.models.Student;
import com.zavolsky.course_03.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> update(Long id, Student student) {
        return studentRepository.findById(id)
                .map(s -> {
                    s.setName(student.getName());
                    s.setAge(student.getAge());
                    return studentRepository.save(s);
                });
    }

    public Student add(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> get(Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> remove(Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.deleteById(id);
                    return student;
                });
    }

    public Collection<Student> getAllByAge(Integer age) {
        return studentRepository.findAllByAge(age);
    }

    public Collection<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    public Collection<Student> findByAgeBetween(Integer min, Integer max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    public Collection<Student> findAllByAgeInterval() {
        return studentRepository.findAllByAgeInterval();
    }

    public ArrayList<String> findAllNamesOnly() {
        return studentRepository.findAllNamesOnly();
    }

    public Collection<Student> findAllWithCh(String ch) {
        return studentRepository.findAllByNameContains(ch);
    }

    public Collection<Student> findAllWhereAgeLessId() {
        return studentRepository.findAllWhereAgeLessId();
    }

    public Collection<Student> findAllBySOrderByAge() {
        return studentRepository.findAllOrderByAge();
    }
}

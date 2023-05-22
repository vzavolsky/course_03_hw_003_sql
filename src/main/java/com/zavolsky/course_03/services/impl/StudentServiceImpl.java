package com.zavolsky.course_03.services.impl;

import com.zavolsky.course_03.models.Student;
import com.zavolsky.course_03.repositories.StudentRepository;
import com.zavolsky.course_03.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    Student student = new Student();

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(String name, int age) {
        student.setName(name);
        student.setAge(age);
        return studentRepository.save(student);
    }

    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student get(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student update(Long id, String name, int age) {
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        return studentRepository.save(student);
    }

    public void remove(Long id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
    }

    public Collection<Student> getAllByAge(Integer age) {
        return studentRepository.findAllByAge(age);
    }

}

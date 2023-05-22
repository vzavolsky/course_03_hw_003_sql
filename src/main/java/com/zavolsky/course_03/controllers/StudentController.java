package com.zavolsky.course_03.controllers;

import com.zavolsky.course_03.exceptions.RequestErrorException;
import com.zavolsky.course_03.models.Student;
import com.zavolsky.course_03.repositories.StudentRepository;
import com.zavolsky.course_03.services.StudentService;
import com.zavolsky.course_03.services.impl.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "/add")
    public Student add(@RequestParam("name") String name, @RequestParam("age") int age) {
        return studentService.add(name, age);
    }

    @GetMapping(path = "/get")
    public Collection<Student> getAll(@RequestParam(value = "age", required = false) Integer age) {
        return age == null ? studentService.getAll() : studentService.getAllByAge(age);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Student> get(@PathVariable("id") Long id) {
        if (id == null) {
            throw new RequestErrorException("Id can't be empty.");
        }
        Student student = studentService.get(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping(path = "/update")
    public Student update(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("age") Integer age) {
        return studentService.update(id, name, age);
    }

    @GetMapping(path = "/remove/{id}")
    public ResponseEntity<Student> remove(@PathVariable("id") Long id) {
        studentService.remove(id);
        return ResponseEntity.ok().build();
    }

}

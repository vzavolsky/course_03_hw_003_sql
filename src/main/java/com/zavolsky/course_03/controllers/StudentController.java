package com.zavolsky.course_03.controllers;

import com.zavolsky.course_03.models.Student;
import com.zavolsky.course_03.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping // Add a student.
    public ResponseEntity<Student> add(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.add(student));
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam(value = "name", required = false) String name) {
        if (name != null && !name.isBlank()) {
            return ResponseEntity.ok(studentService.findByName(name)); // Find student by name field.
        }
        return ResponseEntity.ok(studentService.findAll()); // Find all students.
    }

    @GetMapping(path = "/{id}") // Find a student by ID.
    public ResponseEntity<Optional<Student>> get(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.get(id));
    }

    @PutMapping // Replace a student's data.
    public ResponseEntity<Optional<Student>> update(@RequestBody Long id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(id, student));
    }

    @DeleteMapping // Delete a student.
    public ResponseEntity<Optional<Student>> remove(@RequestBody Long id) {
        return ResponseEntity.ok(studentService.remove(id));
    }

    @GetMapping(path = "/age") // Find students with specific interval of ages.
    public ResponseEntity<Collection<Student>> findAllByAgeInterval(
            @RequestParam(value = "min", required = false) Integer min,
            @RequestParam(value = "max", required = false) Integer max) {
        if (min != null && max != null) {
            return ResponseEntity.ok(studentService.findByAgeBetween(min, max));
        }
        return ResponseEntity.ok(studentService.findAllByAgeInterval());
    }

    @GetMapping(path = "/names") // Return the list with names only.
    public ResponseEntity<ArrayList<String>> findAllNamesOnly() {
        return ResponseEntity.ok(studentService.findAllNamesOnly());
    }

    @GetMapping(path = "/age/asc") // Return the list of students with sorted ages.
    public ResponseEntity<Collection<Student>> findAllOrderByAge() {
        return ResponseEntity.ok(studentService.findAllBySOrderByAge());
    }

    @GetMapping(path = "/agelessid") // Return the list ofr students where their ID less than an age.
    public ResponseEntity<Collection<Student>> findAllWhereAgeLessId() {
        return ResponseEntity.ok(studentService.findAllWhereAgeLessId());
    }

    @GetMapping(path = "/age/{age}") // Find all students with specific age.
    public ResponseEntity<Collection<Student>> findAllByAge(@PathVariable Integer age) {
        return ResponseEntity.ok(studentService.getAllByAge(age));
    }

}

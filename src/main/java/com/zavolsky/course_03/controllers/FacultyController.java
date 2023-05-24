package com.zavolsky.course_03.controllers;

import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.models.Student;
import com.zavolsky.course_03.services.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {

    private FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<Faculty> add(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.add(faculty));
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAll() {
        return ResponseEntity.ok(facultyService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Faculty>> get(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.get(id));
    }

    @PutMapping
    public ResponseEntity<Optional<Faculty>> update(@RequestBody Long id, @RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.update(id, faculty));
    }

    @DeleteMapping
    public ResponseEntity<Optional<Faculty>> remove(@RequestBody Long id) {
        return ResponseEntity.ok(facultyService.remove(id));
    }

    @GetMapping(path = "student/{id}")
    public ResponseEntity<ArrayList<Faculty>> getFacultyByStudentId (@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.getFacultyByStudentId(id));
    }

    @GetMapping(path = "/color/{color}")
    public ResponseEntity<Collection<Faculty>> findAllByColor (@PathVariable String color) {
        return ResponseEntity.ok(facultyService.getAllByColor(color));
    }

    @GetMapping(path = "/nameorcolor/{nameOrColor}")
    public ResponseEntity<Collection<Faculty>> getStudentsByNameOrColor(@PathVariable String nameOrColor) {
        return ResponseEntity.ok(facultyService.getStudentsByNameOrColor(nameOrColor));
    }

}

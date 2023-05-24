package com.zavolsky.course_03.controllers;

import com.zavolsky.course_03.exceptions.RequestErrorException;
import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.services.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {

    private FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<Faculty> add(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.update(faculty));
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAll() {
        return ResponseEntity.ok(facultyService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Faculty> get(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.get(id));
    }

    @PutMapping
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.update(faculty));
    }

    @DeleteMapping
    public ResponseEntity<Faculty> remove(@RequestBody Faculty faculty) {
        facultyService.remove(faculty);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "student/{id}")
    public ResponseEntity<ArrayList<Faculty>> getFacultyByStudentId (@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.getFacultyByStudentId(id));
    }

    @GetMapping(path = "/color/{color}")
    public ResponseEntity<Collection<Faculty>> findAllByColor (@PathVariable String color) {
        return ResponseEntity.ok(facultyService.getAllByColor(color));
    }

}

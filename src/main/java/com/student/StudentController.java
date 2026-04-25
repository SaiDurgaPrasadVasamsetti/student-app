package com.student;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")   // base path
@CrossOrigin
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    // GET all students
    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    // POST new student (JSON)
    @PostMapping
    public Student addStudent(@RequestBody Student s) {
        return repo.save(s);
    }
}

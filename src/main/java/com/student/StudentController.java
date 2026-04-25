
package com.student;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/students")
    public List<Student> getAll() {
        return repo.findAll();
    }

    @PostMapping("/students")
    public Student add(@RequestBody Student s) {
        return repo.save(s);
    }
}

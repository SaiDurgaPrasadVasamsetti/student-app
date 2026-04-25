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

    // GET all students
    @GetMapping("/students")
    public List<Student> getAll() {
        return repo.findAll();
    }

    // FIXED: accept form data
    @PostMapping("/add")
    public String addStudent(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam int marks) {

        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        s.setMarks(marks);

        repo.save(s);

        return "Student Saved";
    }
}

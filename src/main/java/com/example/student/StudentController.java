package com.example.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private List<Student> students = Arrays.asList(
        new Student(1, "Pranav", "CSE"),
        new Student(2, "Rahul", "ECE"),
        new Student(3, "Ananya", "IT")
    );

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Student Management System";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
} 
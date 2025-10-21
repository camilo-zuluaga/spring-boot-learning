package com.camilo.springcrud.rest;

import com.camilo.springcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // Load data after construction
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Juan", "Zuluaga"));
        students.add(new Student("Camilo", "Gomez"));
        students.add(new Student("Samuel", "Porras"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        // Jackson will handle the data binding converting the POJO into JSON
        // It calls the Get methods
        return students;
    }

    // path variable, return the student by index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId >= students.size() || studentId < 0) {
            // throwing exception
            throw new StudentNotFoundException("Student ID not found [%s]".formatted(studentId));
        }

        return students.get(studentId);
    }
}
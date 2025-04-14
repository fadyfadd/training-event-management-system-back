package com.training.training_event_management_system_back.controllers;


import com.training.training_event_management_system_back.entities.Student;
import com.training.training_event_management_system_back.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        Optional<Student> student = studentService.getStudentById(id);
        return student.orElse(null);
    }

    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

}

package com.training.training_event_management_system_back.controllers;

import com.training.training_event_management_system_back.entities.Teacher;
import com.training.training_event_management_system_back.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public List<Teacher>getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable long id){
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.orElse(null);
    }

    @PostMapping("/save")
    public Teacher createStudent(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }


}

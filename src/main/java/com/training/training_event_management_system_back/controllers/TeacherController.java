package com.training.training_event_management_system_back.controllers;

import com.training.training_event_management_system_back.dto.StudentDTO;
import com.training.training_event_management_system_back.dto.TeacherDTO;
import com.training.training_event_management_system_back.entities.Teacher;
import com.training.training_event_management_system_back.services.TeacherService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Transactional
    @GetMapping("/all")
    public List<TeacherDTO>getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacherById(@PathVariable long id){
       return teacherService.getTeacherById(id).orElse(null);
    }

    @Transactional
    @PostMapping("/save")
    public TeacherDTO createTeacher(@RequestBody TeacherDTO teacher) {
        return teacherService.createTeacher(teacher);
    }


}

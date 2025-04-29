package com.training.training_event_management_system_back.controllers;

import com.training.training_event_management_system_back.dto.teacherDto;
import com.training.training_event_management_system_back.services.TeacherService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Transactional
    @GetMapping("/all")
    public ResponseEntity<List<teacherDto>>getAllTeachers(){
        List<teacherDto> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<teacherDto> getTeacherById(@PathVariable long id){
        return teacherService.getTeacherById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<teacherDto> createTeacher(@RequestBody teacherDto teacher) {
        teacherDto createdTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.status(201).body(createdTeacher);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id){
        try {
            teacherService.deleteTeacherById(id);
            return ResponseEntity.ok("deleted teacher " + id);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }



}

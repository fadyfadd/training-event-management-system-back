package com.training.training_event_management_system_back.controllers;

import com.training.training_event_management_system_back.dto.CourseDTO;
import com.training.training_event_management_system_back.dto.EventDTO;
import com.training.training_event_management_system_back.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public ResponseEntity<List<CourseDTO>> getAllEvents(){
        List<CourseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @PostMapping("/add")
    public ResponseEntity<CourseDTO> createEvent(@RequestBody CourseDTO courseDTO){
        CourseDTO addCourse = courseService.addCourse(courseDTO);
        return ResponseEntity.ok(addCourse);
    }
}

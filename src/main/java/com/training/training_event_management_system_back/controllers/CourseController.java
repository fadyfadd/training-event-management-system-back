package com.training.training_event_management_system_back.controllers;

import com.training.training_event_management_system_back.dto.CourseDto;
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
    public ResponseEntity<List<CourseDto>> getAllEvents(){
        List<CourseDto> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @PostMapping("/add")
    public ResponseEntity<CourseDto> createEvent(@RequestBody CourseDto courseDTO){
        CourseDto addCourse = courseService.addCourse(courseDTO);
        return ResponseEntity.ok(addCourse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }


}

package com.training.training_event_management_system_back.controllers;

import com.training.training_event_management_system_back.dto.TeacherDto;
import com.training.training_event_management_system_back.services.JwtService;
import com.training.training_event_management_system_back.services.TeacherService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<TeacherDto>>getAllTeachers(){
        List<TeacherDto> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable long id){
        return teacherService.getTeacherById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody @Valid TeacherDto teacher) {
        TeacherDto createdTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.ok().body(createdTeacher);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id){
        try {
            teacherService.deleteTeacherById(id);
            return ResponseEntity.ok("deleted teacher " + id);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/search")
    public ResponseEntity<Page<TeacherDto>> getTeachersByUsername(
            @RequestParam(required = false) String username,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<TeacherDto> teachers;

        if (username != null && !username.trim().isEmpty()) {
            teachers = teacherService.getTeacherByUsername(username, page, size);
        } else {
            teachers = teacherService.getAllTeachersPaginated(page, size);
        }

        return ResponseEntity.ok(teachers);
    }

}

package com.training.training_event_management_system_back.controllers;

import com.training.training_event_management_system_back.dto.TeacherDto;
import com.training.training_event_management_system_back.services.JwtService;
import com.training.training_event_management_system_back.services.TeacherService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
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

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable long id){
        return teacherService.getTeacherById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacher) {
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

//    @PostMapping("/login")
//    public String login(@RequestBody LoginRequest loginRequest) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            loginRequest.getUserName(),
//                            loginRequest.getPassword()
//                    )
//            );
//
//            if (authentication.isAuthenticated()) {
//                PersonPrincipal principal = (PersonPrincipal) authentication.getPrincipal();
//                String actualRole = principal.getPerson().getRole().getCurrentRole();
//
//                if (!actualRole.equals("ROLE_" + loginRequest.getRole())) {
//                    throw new BusinessException("Incorrect role");
//                }
//
//                return jwtService.generateToken(loginRequest.getUserName());
//            } else {
//                throw new BusinessException("Login failed");
//            }
//        } catch (Exception e) {
//            throw new BusinessException("Invalid username or password");
//        }
//    }


}

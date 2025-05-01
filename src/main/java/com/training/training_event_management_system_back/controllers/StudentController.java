package com.training.training_event_management_system_back.controllers;

import com.training.training_event_management_system_back.dto.LoginRequest;
import com.training.training_event_management_system_back.dto.StudentDto;
import com.training.training_event_management_system_back.entities.Person;
import com.training.training_event_management_system_back.entities.PersonPrincipal;
import com.training.training_event_management_system_back.entities.Student;
import com.training.training_event_management_system_back.exception.BusinessException;
import com.training.training_event_management_system_back.services.JwtService;
import com.training.training_event_management_system_back.services.StudentService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Transactional
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid StudentDto student) {
        StudentDto savedStudent = studentService.createStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        try {
            studentService.deleteStudentById(id);
            return ResponseEntity.ok("deleted student " + id);
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

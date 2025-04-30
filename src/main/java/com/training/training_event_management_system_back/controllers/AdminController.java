package com.training.training_event_management_system_back.controllers;

import com.training.training_event_management_system_back.dto.AdminDto;
import com.training.training_event_management_system_back.dto.TeacherDto;
import com.training.training_event_management_system_back.services.AdminService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto admin) {
        AdminDto createdAdmin = adminService.createAdmin(admin);
        return ResponseEntity.ok().body(createdAdmin);
    }
}

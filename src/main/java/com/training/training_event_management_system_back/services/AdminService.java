package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.dto.AdminDto;
import com.training.training_event_management_system_back.entities.Admin;
import com.training.training_event_management_system_back.mappers.AdminMapper;
import com.training.training_event_management_system_back.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public Admin saveAdmin(Admin admin){
        admin.setPassword(encoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin = adminMapper.toEntity(adminDto);
        Admin savedAdmin = saveAdmin(admin);
        return adminMapper.toDTO(savedAdmin);
    }
}

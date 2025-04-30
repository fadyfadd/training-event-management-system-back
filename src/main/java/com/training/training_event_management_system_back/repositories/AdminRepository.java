package com.training.training_event_management_system_back.repositories;

import com.training.training_event_management_system_back.entities.Admin;
import com.training.training_event_management_system_back.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);

}

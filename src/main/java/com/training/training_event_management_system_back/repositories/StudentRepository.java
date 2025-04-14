package com.training.training_event_management_system_back.repositories;

import com.training.training_event_management_system_back.entities.Person;
import com.training.training_event_management_system_back.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Person> findByUsername(String username);
    List<Person> findByEmail(String email);
}

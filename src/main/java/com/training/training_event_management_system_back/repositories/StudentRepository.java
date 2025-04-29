package com.training.training_event_management_system_back.repositories;

import com.training.training_event_management_system_back.entities.Person;
import com.training.training_event_management_system_back.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsername(String username);
    List<Person> findByEmail(String email);
}

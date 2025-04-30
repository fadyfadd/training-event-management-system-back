package com.training.training_event_management_system_back.repositories;

import com.training.training_event_management_system_back.entities.Person;
import com.training.training_event_management_system_back.entities.Student;
import com.training.training_event_management_system_back.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Long> {
    Teacher findByUsername(String username);
}

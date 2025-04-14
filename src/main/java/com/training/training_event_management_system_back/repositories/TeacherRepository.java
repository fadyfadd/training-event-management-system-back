package com.training.training_event_management_system_back.repositories;

import com.training.training_event_management_system_back.entities.Person;
import com.training.training_event_management_system_back.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository  extends JpaRepository<Teacher, Long> {


}

package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.entities.Teacher;
import com.training.training_event_management_system_back.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    public List<Teacher>getAllTeachers(){
        return teacherRepository.findAll();
    }

    public Optional<Teacher>getTeacherById(Long id){
        return teacherRepository.findById(id);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}

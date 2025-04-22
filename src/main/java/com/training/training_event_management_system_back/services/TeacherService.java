package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.dto.TeacherDTO;
import com.training.training_event_management_system_back.entities.Teacher;
import com.training.training_event_management_system_back.mappers.TeacherMapper;
import com.training.training_event_management_system_back.repositories.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    public List<TeacherDTO>getAllTeachers(){
        List<Teacher> teachers = teacherRepository.findAll();
        return teacherMapper.toDTOList(teachers);
    }

    public Optional<TeacherDTO>getTeacherById(Long id){
        return teacherRepository.findById(id).map(teacherMapper::toDTO);
    }

    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        Teacher saved = teacherRepository.save(teacher);
        return teacherMapper.toDTO(saved);
    }
}

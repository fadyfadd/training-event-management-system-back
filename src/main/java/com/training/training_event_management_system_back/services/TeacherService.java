package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.dto.teacherDto;
import com.training.training_event_management_system_back.entities.Teacher;
import com.training.training_event_management_system_back.mappers.TeacherMapper;
import com.training.training_event_management_system_back.repositories.TeacherRepository;
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

    public List<teacherDto>getAllTeachers(){
        List<Teacher> teachers = teacherRepository.findAll();
        return teacherMapper.toDTOList(teachers);
    }

    public Optional<teacherDto>getTeacherById(Long id){
        return teacherRepository.findById(id).map(teacherMapper::toDTO);
    }

    public teacherDto createTeacher(teacherDto teacherDTO) {
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        Teacher saved = teacherRepository.save(teacher);
        return teacherMapper.toDTO(saved);
    }

    public void deleteTeacherById(Long id){
        if(!teacherRepository.existsById(id)){
            throw new RuntimeException("teacher does not exist " + id);
        }
        teacherRepository.deleteById(id);
    }
}

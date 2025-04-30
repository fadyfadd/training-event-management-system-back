package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.dto.TeacherDto;
import com.training.training_event_management_system_back.entities.Teacher;
import com.training.training_event_management_system_back.enums.Role;
import com.training.training_event_management_system_back.mappers.TeacherMapper;
import com.training.training_event_management_system_back.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    private Role role;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public List<TeacherDto>getAllTeachers(){
        List<Teacher> teachers = teacherRepository.findAll();
        return teacherMapper.toDTOList(teachers);
    }

    public Optional<TeacherDto>getTeacherById(Long id){
        return teacherRepository.findById(id).map(teacherMapper::toDTO);
    }

    public Teacher saveTeacher(Teacher teacher){
        teacher.setPassword(encoder.encode(teacher.getPassword()));
        return teacherRepository.save(teacher);
    }

    public TeacherDto createTeacher(TeacherDto teacherDTO) {
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        Teacher savedTeacher = saveTeacher(teacher);
        return teacherMapper.toDTO(savedTeacher);
    }

    public void deleteTeacherById(Long id){
        if(!teacherRepository.existsById(id)){
            throw new RuntimeException("teacher does not exist " + id);
        }
        teacherRepository.deleteById(id);
    }
}

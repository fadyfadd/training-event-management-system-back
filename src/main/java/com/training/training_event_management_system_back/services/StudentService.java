package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.dto.StudentDTO;
import com.training.training_event_management_system_back.entities.Student;
import com.training.training_event_management_system_back.mappers.StudentMapper;
import com.training.training_event_management_system_back.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return studentMapper.toDTOList(students);
    }

    public Optional<StudentDTO> getStudentById(Long id){
        return studentRepository.findById(id).map(studentMapper::toDTO);
    }

    public StudentDTO createStudent(StudentDTO dto){
        Student student = studentMapper.toEntity(dto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDTO(savedStudent);
    }

}

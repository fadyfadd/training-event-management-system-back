package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.dto.StudentDto;
import com.training.training_event_management_system_back.entities.Student;
import com.training.training_event_management_system_back.enums.Role;
import com.training.training_event_management_system_back.mappers.StudentMapper;
import com.training.training_event_management_system_back.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return studentMapper.toDTOList(students);
    }

    public Optional<StudentDto> getStudentById(Long id){
        return studentRepository.findById(id).map(studentMapper::toDTO);
    }

    public Student saveStudent(Student student){
        student.setPassword(encoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public StudentDto createStudent(StudentDto dto){
        Student student = studentMapper.toEntity(dto);
        Student savedStudent = saveStudent(student);
        return studentMapper.toDTO(savedStudent);
    }

    public void deleteStudentById(Long id){
        if(!studentRepository.existsById(id)){
            throw new RuntimeException("student does not exist " + id);
        }
        studentRepository.deleteById(id);
    }

}

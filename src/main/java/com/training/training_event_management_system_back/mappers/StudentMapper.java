package com.training.training_event_management_system_back.mappers;

import com.training.training_event_management_system_back.dto.StudentDto;
import com.training.training_event_management_system_back.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto toDTO(Student student);
    Student toEntity(StudentDto dto);

    List<StudentDto> toDTOList(List<Student> students);
}

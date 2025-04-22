package com.training.training_event_management_system_back.mappers;

import com.training.training_event_management_system_back.dto.StudentDTO;
import com.training.training_event_management_system_back.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

//    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO toDTO(Student student);
    Student toEntity(StudentDTO dto);

    List<StudentDTO> toDTOList(List<Student> students);
}

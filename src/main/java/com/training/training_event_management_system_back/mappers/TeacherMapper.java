package com.training.training_event_management_system_back.mappers;

import com.training.training_event_management_system_back.dto.teacherDto;
import com.training.training_event_management_system_back.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);


    teacherDto toDTO (Teacher teacher);
    Teacher toEntity (teacherDto dto);

    List<teacherDto> toDTOList (List<Teacher> teachers);

}

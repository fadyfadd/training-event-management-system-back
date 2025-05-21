package com.training.training_event_management_system_back.mappers;

import com.training.training_event_management_system_back.dto.TeacherDto;
import com.training.training_event_management_system_back.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);


    TeacherDto toDTO (Teacher teacher);
    Teacher toEntity (TeacherDto dto);

    List<TeacherDto> toDTOList (List<Teacher> teachers);

}

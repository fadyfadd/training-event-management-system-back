package com.training.training_event_management_system_back.mappers;

import com.training.training_event_management_system_back.dto.CourseDTO;
import com.training.training_event_management_system_back.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

//    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO toDTO(Course course);

    Course toEntity(CourseDTO dto);

    List<CourseDTO> toDTOList(List<Course> courseList);

}

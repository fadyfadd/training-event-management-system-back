package com.training.training_event_management_system_back.mappers;

import com.training.training_event_management_system_back.dto.CourseDto;
import com.training.training_event_management_system_back.entities.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

//    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDto toDTO(Course course);


    Course toEntity(CourseDto dto);

    List<CourseDto> toDTOList(List<Course> courseList);

}

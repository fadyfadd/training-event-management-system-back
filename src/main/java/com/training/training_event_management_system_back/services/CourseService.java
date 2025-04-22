package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.dto.CourseDto;
import com.training.training_event_management_system_back.entities.Course;
import com.training.training_event_management_system_back.exception.BusinessException;
import com.training.training_event_management_system_back.mappers.CourseMapper;
import com.training.training_event_management_system_back.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courseMapper.toDTOList(courses);
    }

    public Optional<Course>getCourseById(Long id){
        return courseRepository.findById(id);
    }

    public CourseDto addCourse(CourseDto courseDTO){
        Course course = courseMapper.toEntity(courseDTO);
        Course addCourse = courseRepository.save(course);
        return courseMapper.toDTO(addCourse);
    }

    public void deleteCourseById(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new BusinessException("Course not found with ID: " + id);
        }
        courseRepository.deleteById(id);
    }

}

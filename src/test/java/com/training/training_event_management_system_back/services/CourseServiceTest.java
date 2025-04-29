package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.dto.CourseDto;
import com.training.training_event_management_system_back.entities.Course;
import com.training.training_event_management_system_back.mappers.CourseMapper;
import com.training.training_event_management_system_back.repositories.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class CourseServiceTest {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    private CourseDto courseDto;

    @BeforeEach
    void setUp() {
       Course courseDto = new Course();
       courseDto.setId(null);
       courseDto.setDescription("test");
        entityManager.persist(courseDto);
    }

    @Transactional
    @Test
    void getAllCourses_1(){
        courseRepository.save(courseMapper.toEntity(courseDto));
        List<CourseDto> courses = courseService.getAllCourses();




    }

}

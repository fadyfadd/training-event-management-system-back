package com.training.training_event_management_system_back.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class EventDTO {
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int maxStudents;

    private CourseDTO course;
    private TeacherDTO teacher;

}

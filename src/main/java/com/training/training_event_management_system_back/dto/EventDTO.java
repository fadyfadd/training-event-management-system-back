package com.training.training_event_management_system_back.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class EventDTO {
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int maxStudents;

    public EventDTO() { }

    public EventDTO(String title, String description, LocalDate startDate, LocalDate endDate, int maxStudents) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxStudents = maxStudents;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public List<Long> getTeacherIds() {
//        return teacherIds;
//    }
//
//    public void setTeacherIds(List<Long> teacherIds) {
//        this.teacherIds = teacherIds;
//    }
}

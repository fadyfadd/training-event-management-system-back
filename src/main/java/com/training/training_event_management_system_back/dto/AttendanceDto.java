package com.training.training_event_management_system_back.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
}

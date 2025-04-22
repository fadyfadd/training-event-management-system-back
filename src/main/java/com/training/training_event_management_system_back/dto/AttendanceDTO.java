package com.training.training_event_management_system_back.dto;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
public class AttendanceDTO {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
}

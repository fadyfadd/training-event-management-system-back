package com.training.training_event_management_system_back.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CertificateDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate issuingDate;
}

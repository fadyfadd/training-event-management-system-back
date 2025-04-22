package com.training.training_event_management_system_back.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class teacherDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public teacherDto() { }

}

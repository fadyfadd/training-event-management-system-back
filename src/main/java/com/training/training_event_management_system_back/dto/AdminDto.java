package com.training.training_event_management_system_back.dto;

import lombok.Data;

@Data
public class AdminDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}

package com.training.training_event_management_system_back.dto;

import com.training.training_event_management_system_back.enums.Role;
import com.training.training_event_management_system_back.validations.WhiteSpaceConstraint;
import lombok.Data;

@Data
public class AdminDto {

    private Long id;
    @WhiteSpaceConstraint
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
}

package com.training.training_event_management_system_back.dto;

import com.training.training_event_management_system_back.enums.Role;
import com.training.training_event_management_system_back.validations.WhiteSpaceConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TeacherDto {
    private Long id;
    @WhiteSpaceConstraint
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate startDate;
    private Role role;

    public TeacherDto() { }

}

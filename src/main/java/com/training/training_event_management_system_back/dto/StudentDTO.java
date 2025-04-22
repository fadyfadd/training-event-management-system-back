package com.training.training_event_management_system_back.dto;

import com.training.training_event_management_system_back.entities.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class StudentDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}

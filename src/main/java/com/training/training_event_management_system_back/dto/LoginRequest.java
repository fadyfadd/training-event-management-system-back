package com.training.training_event_management_system_back.dto;

import com.training.training_event_management_system_back.enums.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class LoginRequest {

    private String userName;
    private String password;
    private Role role;

}

package com.training.training_event_management_system_back.controllers;

import com.training.training_event_management_system_back.dto.LoginRequest;
import com.training.training_event_management_system_back.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return personService.login(loginRequest);
    }

}

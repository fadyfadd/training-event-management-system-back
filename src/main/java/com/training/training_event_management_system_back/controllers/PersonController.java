//package com.training.training_event_management_system_back.controllers;
//
//import com.training.training_event_management_system_back.entities.Person;
//import com.training.training_event_management_system_back.services.JwtService;
//import com.training.training_event_management_system_back.services.PersonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class PersonController {
//
//    @Autowired
//    private PersonService service;
//
//    @Autowired
//    private JwtService jwtService;
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @PostMapping("register")
//    public Person register (@RequestBody Person person){
//        return service.savePerson(person);
//    }
//
//    @PostMapping("login")
//    public String login(@RequestBody Person person){
//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(person.getUsername(), person.getPassword()));
//
//        if(authentication.isAuthenticated())
//            return jwtService.generateToken(person.getUsername());
//        else
//            return "login failed";
//
//    }
//}

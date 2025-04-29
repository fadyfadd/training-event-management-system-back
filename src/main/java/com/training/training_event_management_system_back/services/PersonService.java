//package com.training.training_event_management_system_back.services;
//
//import com.training.training_event_management_system_back.dao.PersonRepo;
//import com.training.training_event_management_system_back.entities.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PersonService {
//
//    @Autowired
//    private PersonRepo repo;
//    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
//
//    public Person savePerson(Person person){
//        person.setPassword(encoder.encode(person.getPassword()));
//        System.out.println(person.getPassword());
//        return repo.save(person);
//    }
//}

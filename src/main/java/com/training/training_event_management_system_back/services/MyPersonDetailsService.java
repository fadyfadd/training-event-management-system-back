package com.training.training_event_management_system_back.services;

//import com.training.training_event_management_system_back.dao.PersonRepo;
import com.training.training_event_management_system_back.entities.Person;
import com.training.training_event_management_system_back.entities.PersonPrincipal;
import com.training.training_event_management_system_back.entities.Student;
import com.training.training_event_management_system_back.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;

@Service
public class MyPersonDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Student person = repo.findByUsername(username);

        if(person == null){
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }
        return new PersonPrincipal(person);
    }
}

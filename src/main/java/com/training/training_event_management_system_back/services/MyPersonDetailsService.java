package com.training.training_event_management_system_back.services;

//import com.training.training_event_management_system_back.dao.PersonRepo;
import com.training.training_event_management_system_back.entities.*;
import com.training.training_event_management_system_back.repositories.AdminRepository;
import com.training.training_event_management_system_back.repositories.StudentRepository;
import com.training.training_event_management_system_back.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;

@Service
public class MyPersonDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = null;

        Student student = studentRepository.findByUsername(username);
        if (student != null) {
            person = student;
        }

        if (person == null) {
            Teacher teacher = teacherRepository.findByUsername(username);
            if (teacher != null) {
                person = teacher;
            }
        }

        if (person == null) {
            Admin admin = adminRepository.findByUsername(username);
            if (admin != null) {
                person = admin;
            }
        }

        if (person == null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }

        return new PersonPrincipal(person);
    }
}



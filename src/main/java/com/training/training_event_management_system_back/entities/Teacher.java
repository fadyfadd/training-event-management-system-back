package com.training.training_event_management_system_back.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "teachers")
public class Teacher extends Person{


    private LocalDate startDate;

    protected Teacher() {}

//    public Teacher(Person person, LocalDate startDate) {
//        this.person = person;
//        this.startDate = startDate;
//    }

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}

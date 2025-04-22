package com.training.training_event_management_system_back.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "students")
public class Student extends Person {

    public Student() { }

    @ManyToMany
    @JoinTable(name = "event_student",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name = "event_id")
                )
    private Set<Event> events;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Attendance> attendances;

}

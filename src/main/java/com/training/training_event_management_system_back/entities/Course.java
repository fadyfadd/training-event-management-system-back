package com.training.training_event_management_system_back.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int numberOfHours;

    @Column(nullable = false)
    private int minAttendance;

    @ManyToMany(mappedBy = "courses")
    private Set<Teacher> teachers;

//    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
//    private Certificate certificate;

    @OneToMany(mappedBy = "course")
    private List<Event> events;

}

package com.training.training_event_management_system_back.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private int maxStudents;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany(mappedBy = "events")
    private Set<Student> students = new HashSet<>();
//    private Set<Student> students;

    //One to many with attendance
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Attendance> attendances;

    //One to many with certificates
    @OneToMany(mappedBy = "event")
    private List<Certificate> certificates;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}

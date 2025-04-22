package com.training.training_event_management_system_back.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate issuingDate;

//    @OneToOne
//    @JoinColumn(name = "course_id", referencedColumnName = "id")
//    private Course course;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    protected Certificate() { }
}

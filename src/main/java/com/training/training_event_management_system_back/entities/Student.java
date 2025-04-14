package com.training.training_event_management_system_back.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "students")
public class Student extends Person {


    protected Student() { }

}

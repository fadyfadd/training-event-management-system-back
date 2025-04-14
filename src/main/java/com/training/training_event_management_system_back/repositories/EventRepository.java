package com.training.training_event_management_system_back.repositories;

import com.training.training_event_management_system_back.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Long> {

}

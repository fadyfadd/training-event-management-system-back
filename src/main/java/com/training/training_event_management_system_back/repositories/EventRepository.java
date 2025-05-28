package com.training.training_event_management_system_back.repositories;

import com.training.training_event_management_system_back.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findEventByTeacherUsername(String username);
    @Query("SELECT e FROM Event e JOIN e.students s WHERE s.username = :username")
    List<Event> findEventsByStudentUsername(@Param("username") String username);

}

package com.training.training_event_management_system_back.controllers;

import com.training.training_event_management_system_back.dto.CourseDto;
import com.training.training_event_management_system_back.dto.EventDto;
import com.training.training_event_management_system_back.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List <EventDto>>getAllEvents(){
        List<EventDto> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long id){
        return eventService.getEventById(id).map(ResponseEntity::ok).orElse(null);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDTO){
        EventDto saveEvent = eventService.createEvent(eventDTO);
        return ResponseEntity.ok(saveEvent);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}/course")
    public ResponseEntity<CourseDto> getCourseByEventId(@PathVariable Long id) {
        return eventService.getCourseByEventId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id){
        try {
            eventService.deleteEventById(id);
            return ResponseEntity.ok("deleted event " + id);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }




}

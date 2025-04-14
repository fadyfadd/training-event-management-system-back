package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.dto.EventDTO;
import com.training.training_event_management_system_back.entities.Event;
import com.training.training_event_management_system_back.repositories.EventRepository;
import com.training.training_event_management_system_back.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public Optional<Event> getEventById(Long id){
        return eventRepository.findById(id);
    }

//    public Event createEvent(EventDTO eventDTO){
//        EventDTO event = new EventDTO();
//        event.setTitle().;
//    }
}

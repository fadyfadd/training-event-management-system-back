package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.dto.CourseDTO;
import com.training.training_event_management_system_back.dto.EventDTO;
import com.training.training_event_management_system_back.entities.Course;
import com.training.training_event_management_system_back.entities.Event;
import com.training.training_event_management_system_back.entities.Teacher;
import com.training.training_event_management_system_back.mappers.CourseMapper;
import com.training.training_event_management_system_back.mappers.EventMapper;
import com.training.training_event_management_system_back.repositories.CourseRepository;
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
    private EventMapper eventMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public Optional<EventDTO> getEventById(Long id){
        return eventRepository.findById(id).map(eventMapper::toDTO);
    }

    public List<EventDTO> getAllEvents(){
        List<Event> events = eventRepository.findAll();
        return eventMapper.toDTOList(events);
    }

    public EventDTO createEvent(EventDTO eventDTO){
        Event event = eventMapper.toEntity(eventDTO);

        if (eventDTO.getCourse().getId() != null){
            Course course = courseRepository.findById(eventDTO.getCourse().getId())
                    .orElseThrow(() -> new RuntimeException("Course not found: " + eventDTO.getCourse().getId()));
            event.setCourse(course);
        }

        if ( eventDTO.getTeacher().getId() != null){
            Teacher teacher = teacherRepository.findById(eventDTO.getTeacher().getId())
                    .orElseThrow(() -> new RuntimeException("Teacher not found: " + eventDTO.getTeacher().getId()));
            event.setTeacher(teacher);
        }

        Event saveEvent = eventRepository.save(event);
        return eventMapper.toDTO(saveEvent);
    }

    public Optional<CourseDTO> getCourseByEventId(Long eventId) {
        return eventRepository.findById(eventId)
                .map(Event::getCourse)
                .map(courseMapper::toDTO);
    }
}

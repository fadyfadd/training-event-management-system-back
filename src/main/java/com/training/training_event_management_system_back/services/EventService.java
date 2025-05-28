package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.dto.CourseDto;
import com.training.training_event_management_system_back.dto.EventDto;
import com.training.training_event_management_system_back.entities.Course;
import com.training.training_event_management_system_back.entities.Event;
import com.training.training_event_management_system_back.entities.Student;
import com.training.training_event_management_system_back.entities.Teacher;
import com.training.training_event_management_system_back.mappers.CourseMapper;
import com.training.training_event_management_system_back.mappers.EventMapper;
import com.training.training_event_management_system_back.mappers.StudentMapper;
import com.training.training_event_management_system_back.repositories.CourseRepository;
import com.training.training_event_management_system_back.repositories.EventRepository;
import com.training.training_event_management_system_back.repositories.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.training.training_event_management_system_back.dto.StudentDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;
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

    @Autowired
    private StudentMapper studentMapper;

    public Optional<EventDto> getEventById(Long id){
        return eventRepository.findById(id).map(eventMapper::toDTO);
    }

    public List<EventDto> getAllEvents(){
        List<Event> events = eventRepository.findAll();
        return eventMapper.toDTOList(events);
    }

    public EventDto createEvent(EventDto eventDTO){
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

    public Optional<CourseDto> getCourseByEventId(Long eventId) {
        return eventRepository.findById(eventId)
                .map(Event::getCourse)
                .map(courseMapper::toDTO);
    }

    public void deleteEventById(Long id){
        if(!eventRepository.existsById(id)){
            throw new RuntimeException("Event not found" + id);
        }
        eventRepository.deleteById(id);
    }

    public List<EventDto> getEventByStudentUsername(String username) {
        List<Event> events = eventRepository.findEventsByStudentUsername(username);
        return eventMapper.toDTOList(events);
    }


    public List<EventDto> getEventByTeacherUsername(String username){
        List<Event> events = eventRepository.findEventByTeacherUsername(username);
        return eventMapper.toDTOList(events);
    }

    @Transactional
    public List<StudentDto> getStudentsByEvent(Long eventId){
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        Set<Student> students = event.getStudents();
        return students.stream().map(studentMapper::toDTO).collect(Collectors.toList());
    }

    public Page<EventDto> getAllEventsPaginated(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Event> eventPage = eventRepository.findAll(pageable);
        return eventPage.map(eventMapper::toDTO);
    }

    @Transactional
    public void unregisterStudentFromEvent(Long eventId, String username) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + eventId));

        Student studentToRemove = event.getStudents().stream()
                .filter(student -> student.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not registered for this event"));

        event.getStudents().remove(studentToRemove);
        studentToRemove.getEvents().remove(event);

        eventRepository.save(event); // save event
    }


}

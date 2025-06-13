package com.training.training_event_management_system_back.services;

import com.training.training_event_management_system_back.dto.EventDto;
import com.training.training_event_management_system_back.dto.StudentDto;
import com.training.training_event_management_system_back.entities.Event;
import com.training.training_event_management_system_back.entities.Student;
import com.training.training_event_management_system_back.enums.Role;
import com.training.training_event_management_system_back.mappers.EventMapper;
import com.training.training_event_management_system_back.mappers.StudentMapper;
import com.training.training_event_management_system_back.repositories.EventRepository;
import com.training.training_event_management_system_back.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public List<StudentDto> getAllStudents(){
//        List<Student> students = studentRepository.findAll();
        return studentRepository.findAll().stream().map(student -> studentMapper.toDTO(student)).collect(Collectors.toList());
    }

    public Optional<StudentDto> getStudentById(Long id){
        return studentRepository.findById(id).map(studentMapper::toDTO);
    }

    public Student saveStudent(Student student){
        student.setPassword(encoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public StudentDto createStudent(StudentDto dto){
        Student student = studentMapper.toEntity(dto);
        Student savedStudent = saveStudent(student);
        return studentMapper.toDTO(savedStudent);
    }

    public void deleteStudentById(Long id){
        if(!studentRepository.existsById(id)){
            throw new RuntimeException("student does not exist " + id);
        }
        studentRepository.deleteById(id);
    }

    public String registerStudentToEvent(Long studentId, Long eventId){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + eventId));

        if(student.getEvents().contains(event)){
            return "Student is already registered in this event";
        }

        if(event.getStudents().size() >= event.getMaxStudents()){
            return "Event is full. Cannot register student";
        }

        student.getEvents().add(event);
        event.getStudents().add(student);

        studentRepository.save(student);
        eventRepository.save(event);

        return "Student registered successfully";
    }

    public List<EventDto> getEventsByStudentId(Long studentId){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));

        return student.getEvents()
                .stream()
                .map(eventMapper::toDTO)
                .toList();
    }

    public String unregisterStudentFromEvent(Long studentId, Long eventId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + eventId));

        if (!student.getEvents().contains(event)) {
            return "Student is not registered for this event.";
        }

        student.getEvents().remove(event);
        event.getStudents().remove(student);

        studentRepository.save(student);
        return "Student unregistered from event successfully.";
    }

    public Page<StudentDto> getAllStudentsPaginated(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage.map(studentMapper::toDTO);
    }

    public Page<StudentDto> getStudentsByUsername(String username, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentsPage = studentRepository.findByUsernameContainingIgnoreCase(username, pageable);
        return studentsPage.map(studentMapper::toDTO);
    }
}

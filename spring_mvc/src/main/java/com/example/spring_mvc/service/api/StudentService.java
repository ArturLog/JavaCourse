package com.example.spring_mvc.service.api;

import com.example.spring_mvc.entities.Room;
import com.example.spring_mvc.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface StudentService {
    Optional<Student> findByName(String name);
    Optional<Student> find(UUID id);
    List<Student> findAll();
    List<Student> findAll(Room room);
    void create(Student student);
    void delete(UUID id);
    void delete(String name);
}

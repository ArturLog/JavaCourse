package com.example.spring_mvc.service.impl;

import com.example.spring_mvc.entities.Room;
import com.example.spring_mvc.entities.Student;
import com.example.spring_mvc.repository.StudentRepository;
import com.example.spring_mvc.service.api.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StudentDefaultService implements StudentService {
    private final StudentRepository repository;
    @Override
    public Optional<Student> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<Student> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Student> findAll(Room room) {
        return repository.findAllByRoom(room);
    }

    @Override
    public void create(Student student) {
        repository.save(student);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public void delete(String name) {
        repository.findByName(name).ifPresent(repository::delete);
    }
}

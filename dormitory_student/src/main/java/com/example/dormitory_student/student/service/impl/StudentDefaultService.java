package com.example.dormitory_student.student.service.impl;

import com.example.dormitory_student.room.entity.Room;
import com.example.dormitory_student.student.entity.Student;
import com.example.dormitory_student.student.repository.api.StudentRepository;
import com.example.dormitory_student.student.service.api.StudentService;
import lombok.RequiredArgsConstructor;
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
    public void updateStudentById(UUID uuid, Student student) {
        student.setId(uuid);
        repository.save(student);
    }

    @Override
    public List<Student> findRoomStudents(UUID id) {
        return repository.findAll().stream().filter(student -> student.getRoom().getId().equals(id)).toList();
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

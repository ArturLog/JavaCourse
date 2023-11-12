package com.example.dormitory_student.student.service.api;

import com.example.dormitory_student.room.entity.Room;
import com.example.dormitory_student.student.entity.Student;
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
    void updateStudentById(UUID uuid, Student student);

    List<Student> findRoomStudents(UUID id);
    void delete(UUID id);
    void delete(String name);
}
package com.example.dormitory_student.student.repository.api;

import com.example.dormitory_student.room.entity.Room;
import com.example.dormitory_student.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    List<Student> findAllByRoom(Room room);
    Optional<Student> findByName(String name);
}

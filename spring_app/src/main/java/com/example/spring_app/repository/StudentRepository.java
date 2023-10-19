package com.example.spring_app.repository;

import com.example.spring_app.entities.Room;
import com.example.spring_app.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    List<Student> findAllByRoom(Room room);
    Optional<Student> findByName(String name);
}

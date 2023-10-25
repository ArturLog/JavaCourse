package com.example.spring_mvc.service.api;

import com.example.spring_mvc.entities.Room;
import com.example.spring_mvc.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface RoomService {
    Optional<Room> find(UUID id);
    Optional<Room> findByName(String name);
    List<Room> findAll();
    void create(Room room);
    void delete(UUID id);
    void delete(String name);
}

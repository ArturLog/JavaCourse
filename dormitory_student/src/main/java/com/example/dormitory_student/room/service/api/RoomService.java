package com.example.dormitory_student.room.service.api;

import com.example.dormitory_student.room.entity.Room;
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
    void updateRoomById(UUID uuid, Room room);
    void delete(UUID id);
    void delete(String name);
}


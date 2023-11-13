package com.example.dormitory_student.room.repository;

import com.example.dormitory_student.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {
    Optional<Room> findByName(String name);
}

package com.example.dormitory_room.room.event.repository.api;

import com.example.dormitory_room.room.entity.Room;

import java.util.UUID;

public interface RoomEventRepository {
    void delete(UUID id);
    void create(UUID id, Room room);
}

package com.example.dormitory_room.room.event.repository.api;

import java.util.UUID;

public interface RoomEventRepository {
    void delete(UUID id);
    void create(UUID id);
}

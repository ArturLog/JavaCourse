package com.example.dormitory_room.room.event.repository.rest;

import com.example.dormitory_room.room.entity.Room;
import com.example.dormitory_room.room.event.repository.api.RoomEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class RoomEventRestRepository implements RoomEventRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public RoomEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/rooms/{id}", id);
    }

    @Override
    public void create(UUID id){
        Room room = Room.builder().build();
        restTemplate.put("/api/rooms/{id}", id);
    }
}

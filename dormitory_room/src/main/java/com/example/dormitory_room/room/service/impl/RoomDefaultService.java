package com.example.dormitory_room.room.service.impl;

import com.example.dormitory_room.room.entity.Room;
import com.example.dormitory_room.room.event.repository.rest.RoomEventRestRepository;
import com.example.dormitory_room.room.repository.RoomRepository;
import com.example.dormitory_room.room.service.api.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RoomDefaultService implements RoomService {

    private final RoomRepository repository;
    private final RoomEventRestRepository restRepository;
    @Override
    public Optional<Room> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Room> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Room> findAll() {
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    @Override
    public void create(Room room) {
        repository.save(room);
    }

    @Override
    public void updateRoomById(UUID uuid, Room room) {
        room.setId(uuid);
        repository.save(room);
        restRepository.create(uuid);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
        restRepository.delete(id);
    }

    @Override
    public void delete(String name) {
        repository.findByName(name).ifPresent(repository::delete);
    }
}

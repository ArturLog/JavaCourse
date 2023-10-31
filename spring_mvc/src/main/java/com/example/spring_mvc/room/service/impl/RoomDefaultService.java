package com.example.spring_mvc.room.service.impl;

import com.example.spring_mvc.room.entity.Room;
import com.example.spring_mvc.room.repository.RoomRepository;
import com.example.spring_mvc.room.service.api.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RoomDefaultService implements RoomService {

    private final RoomRepository repository;
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
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(String name) {
        repository.findByName(name).ifPresent(repository::delete);
    }
}

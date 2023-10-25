package com.example.spring_mvc.service.impl;

import com.example.spring_mvc.entities.Room;
import com.example.spring_mvc.repository.RoomRepository;
import com.example.spring_mvc.service.api.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
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
        return repository.findAll();
    }

    @Override
    public void create(Room room) {
        repository.save(room);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public void delete(String name) {
        repository.findByName(name).ifPresent(repository::delete);
    }
}

package com.example.dormitory_room.room.initialize;


import com.example.dormitory_room.room.entity.Room;
import com.example.dormitory_room.room.service.impl.RoomDefaultService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class InitializeData implements InitializingBean {

    private final RoomDefaultService roomService;


    @Override
    public void afterPropertiesSet() throws Exception {
        if (roomService.findAll().isEmpty()) {
            Room room1 = Room.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                    .name("1A")
                    .bedsNumber(1)
                    .build();

            Room room2 = Room.builder()
                    .id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4e"))
                    .name("1B")
                    .bedsNumber(1)
                    .build();

            Room room3 = Room.builder()
                    .id(UUID.fromString("ed6cfb2a-cad7-47dd-9b56-9d1e3c7a4197"))
                    .name("2A")
                    .bedsNumber(2)
                    .build();

            roomService.create(room1);
            roomService.create(room2);
            roomService.create(room3);
        }
    }

    @SneakyThrows
    private byte[] getResourceAsByteArray(String name) {
        try (InputStream is = this.getClass().getResourceAsStream(name)) {
            return is.readAllBytes();
        }
    }
}

package com.example.dormitory_student.room.controller;

import com.example.dormitory_student.room.dto.GetRoomsResponse;
import com.example.dormitory_student.room.dto.PutRoomRequest;
import com.example.dormitory_student.room.entity.Room;
import com.example.dormitory_student.room.mapper.RoomMapper;
import com.example.dormitory_student.room.service.api.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RoomDefaultController {
    private final RoomService roomService;
    private final RoomMapper roomMapper;

    @GetMapping("/api/rooms")
    public ResponseEntity<GetRoomsResponse> getRooms(){
        return ResponseEntity.ok(GetRoomsResponse.builder().rooms(roomService.findAll().stream().map(roomMapper::RoomToRoomDto).toList()).build());
    }

    @DeleteMapping("/api/rooms/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable("id") UUID uuid){
        roomService.delete(uuid);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("api/rooms/{id}")
    public ResponseEntity<Void> putRoom(@PathVariable("id") UUID uuid, @RequestBody Room room){
        roomService.updateRoomById(uuid, room);
        return ResponseEntity.accepted().build();
    }
}

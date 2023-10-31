package com.example.spring_mvc.room.controller;

import com.example.spring_mvc.room.dto.GetRoomsResponse;
import com.example.spring_mvc.room.dto.GetRoomResponse;
import com.example.spring_mvc.room.dto.PutRoomRequest;
import com.example.spring_mvc.room.mapper.RoomMapper;
import com.example.spring_mvc.room.service.impl.RoomDefaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
public class RoomController {
    public final String Room_PATH = "/api/rooms";
    public final String Room_PATH_ID = Room_PATH +"/{RoomId}";
    private final RoomMapper RoomMapper;
    private final RoomDefaultService RoomService;


    @GetMapping(Room_PATH)
    public ResponseEntity<GetRoomsResponse> getRooms(){
        return ResponseEntity.ok(GetRoomsResponse.builder().rooms(RoomService.findAll().stream().map(RoomMapper::RoomToRoomDto).toList()).build());
    }
    @GetMapping(Room_PATH_ID)
    public ResponseEntity<GetRoomResponse> getRoom(@PathVariable("RoomId")UUID uuid){
        try{
            return ResponseEntity.ok(RoomService.find(uuid).map(RoomMapper::RoomToGetRoomResponse).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
        }
        catch (Exception e){
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
    }
    @PutMapping(Room_PATH_ID)
    public ResponseEntity<Void> putRoom(@PathVariable("RoomId") UUID uuid, @RequestBody PutRoomRequest request){
        RoomService.updateRoomById(uuid, RoomMapper.putRoomRequestToRoom(request));
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(Room_PATH_ID)
    public ResponseEntity<Void> deleteRoom(@PathVariable("RoomId") UUID uuid){
        RoomService.delete(uuid);
        return ResponseEntity.accepted().build();
    }
}

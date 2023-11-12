package com.example.dormitory_room.room.mapper;

import com.example.dormitory_room.room.dto.GetRoomResponse;
import com.example.dormitory_room.room.dto.PutRoomRequest;
import com.example.dormitory_room.room.dto.RoomDto;
import com.example.dormitory_room.room.entity.Room;
import org.mapstruct.Mapper;

@Mapper
public interface RoomMapper {
    Room RoomDtoToRoom(RoomDto RoomDto);
    RoomDto RoomToRoomDto(Room Room);
    GetRoomResponse RoomToGetRoomResponse(Room Room);
    Room putRoomRequestToRoom(PutRoomRequest putRoomRequest);
}

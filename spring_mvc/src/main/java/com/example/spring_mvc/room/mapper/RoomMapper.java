package com.example.spring_mvc.room.mapper;

import com.example.spring_mvc.room.dto.GetRoomResponse;
import com.example.spring_mvc.room.dto.PutRoomRequest;
import com.example.spring_mvc.room.dto.RoomDto;
import com.example.spring_mvc.room.entity.Room;
import org.mapstruct.Mapper;

@Mapper
public interface RoomMapper {
    Room RoomDtoToRoom(RoomDto RoomDto);
    RoomDto RoomToRoomDto(Room Room);
    GetRoomResponse RoomToGetRoomResponse(Room Room);
    Room putRoomRequestToRoom(PutRoomRequest putRoomRequest);
}

package com.example.dormitory_student.room.mapper;

import com.example.dormitory_student.room.dto.PutRoomRequest;
import com.example.dormitory_student.room.dto.RoomDto;
import com.example.dormitory_student.room.entity.Room;
import org.mapstruct.Mapper;

@Mapper
public interface RoomMapper {
    RoomDto RoomToRoomDto(Room Room);
    Room putRoomRequestToRoom(PutRoomRequest putRoomRequest);

}

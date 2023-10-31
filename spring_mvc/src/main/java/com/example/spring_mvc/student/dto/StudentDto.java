package com.example.spring_mvc.student.dto;

import com.example.spring_mvc.room.dto.RoomDto;
import com.example.spring_mvc.room.entity.Room;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class StudentDto {
    private UUID id;
    private String name;
    private String surname;
    private RoomDto room;
}

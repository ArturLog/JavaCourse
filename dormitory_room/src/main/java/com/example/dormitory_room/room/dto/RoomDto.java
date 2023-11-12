package com.example.dormitory_room.room.dto;

import com.example.dormitory_room.student.dto.StudentDto;
import com.example.dormitory_room.student.entity.Student;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class RoomDto {
    private UUID id;
    private String name;
    private int bedsNumber;
}

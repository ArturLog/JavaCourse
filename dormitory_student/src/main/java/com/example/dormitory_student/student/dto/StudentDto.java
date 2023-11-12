package com.example.dormitory_student.student.dto;

import com.example.dormitory_student.room.dto.RoomDto;
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

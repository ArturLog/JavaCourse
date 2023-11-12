package com.example.dormitory_room.room.dto;

import com.example.dormitory_room.student.dto.StudentDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetRoomResponse {
    private UUID id;
    private String name;
    private int bedsNumber;
    private StudentDto student;
}

package com.example.spring_mvc.room.dto;

import com.example.spring_mvc.student.dto.StudentDto;
import com.example.spring_mvc.student.entity.Student;
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
public class RoomDto {
    private UUID id;
    private String name;
    private int bedsNumber;
}

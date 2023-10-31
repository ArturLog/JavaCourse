package com.example.spring_mvc.student.dto;

import com.example.spring_mvc.room.dto.RoomDto;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetStudentResponse {
    private UUID id;
    private String name;
    private String surname;
}

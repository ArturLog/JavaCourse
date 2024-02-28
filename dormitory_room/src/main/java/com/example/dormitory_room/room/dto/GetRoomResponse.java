package com.example.dormitory_room.room.dto;

import lombok.*;

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
    private Integer bedsNumber;
}

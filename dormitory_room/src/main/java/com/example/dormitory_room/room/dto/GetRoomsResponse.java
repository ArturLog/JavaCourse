package com.example.dormitory_room.room.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetRoomsResponse {
    @Singular
    private List<RoomDto> rooms;
}

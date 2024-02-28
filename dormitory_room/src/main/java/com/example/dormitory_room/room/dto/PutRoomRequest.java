package com.example.dormitory_room.room.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutRoomRequest {
    private String name;
    private Integer bedsNumber;
}

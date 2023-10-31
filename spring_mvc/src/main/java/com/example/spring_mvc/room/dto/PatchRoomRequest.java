package com.example.spring_mvc.room.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchRoomRequest {
    private String name;
    private int bedsNumber;
}

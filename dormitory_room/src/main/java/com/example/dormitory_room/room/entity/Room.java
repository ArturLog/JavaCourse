package com.example.dormitory_room.room.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Comparator;
import java.util.UUID;

@Builder
@Data
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "rooms")
public class Room implements Comparable<Room>{
    @Id
    private UUID id;

    private String name;

    private int bedsNumber;

    @Override
    public int compareTo(Room o) {
        return Comparator.comparing(Room::getName)
                .compare(this, o);
    }
}

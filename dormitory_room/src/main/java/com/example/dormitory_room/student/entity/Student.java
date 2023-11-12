package com.example.dormitory_room.student.entity;

import com.example.dormitory_room.room.entity.Room;
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
@Table(name = "students")
public class Student implements Comparable<Student>{
    @Id
    private UUID id;

    private String name;
    private String surname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
    private Room room;

    @Override
    public int compareTo(Student o) {
        return Comparator.comparing(Student::getName)
                .thenComparing(Student::getId)
                .compare(this, o);
    }
}
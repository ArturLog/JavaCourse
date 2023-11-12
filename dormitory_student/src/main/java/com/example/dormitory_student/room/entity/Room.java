package com.example.dormitory_student.room.entity;

import com.example.dormitory_student.student.entity.Student;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


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

    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }

    @Override
    public int compareTo(Room o) {
        return Comparator.comparing(Room::getName)
                .compare(this, o);
    }
}

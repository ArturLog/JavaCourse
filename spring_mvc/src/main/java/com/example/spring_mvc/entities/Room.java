package com.example.spring_mvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    @OneToMany(mappedBy = "room")
    private List<Student> students = new ArrayList<>();;

    public void addStudent(Student student){
        students.add(student);
    }

    @Override
    public String toString(){
        return "\nRoom:" +
                "\nNumber: " + name +
                "\nNumber of beds: " + bedsNumber +
                "\nStudents: " + students;
    }

    @Override
    public int compareTo(Room o) {
        return Comparator.comparing(Room::getName)
                .compare(this, o);
    }
}

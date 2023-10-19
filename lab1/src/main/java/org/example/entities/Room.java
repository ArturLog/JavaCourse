package org.example.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Builder
@Data
public class Room implements Comparable<Room>, Serializable {
    int roomNumber;
    int bedsNumber;
    @Builder.Default
    @EqualsAndHashCode.Exclude
    List<Student> students = new ArrayList<>();

    public int getRoomNumber() {
        return roomNumber;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    @Override
    public String toString(){
        return "\nRoom:" +
                "\nNumber: " + roomNumber +
                "\nNumber of beds: " + bedsNumber +
                "\nStudents: " + students;
    }

    @Override
    public int compareTo(Room o) {
        return Comparator.comparing(Room::getRoomNumber)
                .compare(this, o);
    }
}

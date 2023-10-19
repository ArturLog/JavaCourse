package org.example.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Comparator;

@Builder
@Data
public class Student implements Comparable<Student>, Serializable {
    int id;
    String name;
    @ToString.Exclude
    Room room;

    @Override
    public String toString(){
        return "\nStudent:" +
                "\nName: " + name +
                "\nStudent id: " + id +
                "\nRoom number: " + room.getRoomNumber();
    }

    @Override
    public int compareTo(Student o) {
        return Comparator.comparing(Student::getName)
                .thenComparing(Student::getId)
                .compare(this, o);
    }
}

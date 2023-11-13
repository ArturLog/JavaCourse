package com.example.dormitory_student.student.initialize;

import com.example.dormitory_student.room.entity.Room;
import com.example.dormitory_student.room.service.impl.RoomDefaultService;
import com.example.dormitory_student.student.entity.Student;
import com.example.dormitory_student.student.service.impl.StudentDefaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class InitializeData implements InitializingBean {
    private final StudentDefaultService studentService;
    private final RoomDefaultService roomService;

    @Override
    public void afterPropertiesSet() throws Exception {

        Room room1 = Room.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .name("1A")
                .bedsNumber(1)
                .build();

        Room room2 = Room.builder()
                .id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4e"))
                .name("1B")
                .bedsNumber(1)
                .build();

        Room room3 = Room.builder()
                .id(UUID.fromString("ed6cfb2a-cad7-47dd-9b56-9d1e3c7a4197"))
                .name("2A")
                .bedsNumber(2)
                .build();

        roomService.create(room1);
        roomService.create(room2);
        roomService.create(room3);

        Student student1 = Student.builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                .name("Bob")
                .surname("Nowak")
                .room(room1)
                .build();

        Student student2 = Student.builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e77"))
                .name("Andrzej")
                .surname("Michalski'")
                .room(room2)
                .build();

        Student student3 = Student.builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e78"))
                .name("Adam")
                .surname("Lewy")
                .room(room3)
                .build();

        Student student4 = Student.builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e79"))
                .name("Aleksander")
                .surname("Szewczyk")
                .room(room3)
                .build();

        studentService.create(student1);
        studentService.create(student2);
        studentService.create(student3);
        studentService.create(student4);
    }
}

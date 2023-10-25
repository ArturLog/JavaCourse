package com.example.spring_mvc.dto;

import com.example.spring_mvc.entities.Student;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class RoomDto {
    private UUID id;
    private String name;
    private int bedsNumber;
    private List<String> students = new ArrayList<>();;
}

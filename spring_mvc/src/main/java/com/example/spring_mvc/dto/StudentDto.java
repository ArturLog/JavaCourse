package com.example.spring_mvc.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class StudentDto {
    private UUID id;
    private String name;
    private String surname;
    private String room;
}

package com.example.spring_app.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Builder
@Data
public class StudentDto implements Serializable {
    private UUID id;
    private Integer version;

    private String name;
    private String room;
}

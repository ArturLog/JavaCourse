package com.example.spring_mvc.student.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutStudentRequest {
    private String name;
    private String surname;
    private UUID room;
}

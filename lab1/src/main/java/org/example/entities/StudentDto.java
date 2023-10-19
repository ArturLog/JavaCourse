package org.example.entities;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class StudentDto implements Serializable {
    Integer id;
    String name;
    String room;
}

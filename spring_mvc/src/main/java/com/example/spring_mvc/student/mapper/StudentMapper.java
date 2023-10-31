package com.example.spring_mvc.student.mapper;

import com.example.spring_mvc.room.entity.Room;
import com.example.spring_mvc.student.dto.GetStudentResponse;
import com.example.spring_mvc.student.dto.PutStudentRequest;
import com.example.spring_mvc.student.dto.StudentDto;
import com.example.spring_mvc.student.entity.Student;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper
public interface StudentMapper {
    Student StudentDtoToStudent(StudentDto StudentDto);
    StudentDto StudentToStudentDto(Student Student);
    GetStudentResponse StudentToGetStudentResponse(Student Student);
    default Student putStudentRequestToStudent(UUID uuid, PutStudentRequest putStudentRequest) {
        if (putStudentRequest == null) {
            return null;
        }
        return Student.builder()
                .id(uuid)
                .name(putStudentRequest.getName())
                .surname(putStudentRequest.getSurname())
                .room(Room.builder()
                        .id(putStudentRequest.getRoom())
                        .build())
                .build();
    }
}

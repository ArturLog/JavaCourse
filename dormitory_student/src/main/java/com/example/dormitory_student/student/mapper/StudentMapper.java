package com.example.dormitory_student.student.mapper;

import com.example.dormitory_student.room.entity.Room;
import com.example.dormitory_student.student.dto.GetStudentResponse;
import com.example.dormitory_student.student.dto.PutStudentRequest;
import com.example.dormitory_student.student.dto.StudentDto;
import com.example.dormitory_student.student.entity.Student;
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

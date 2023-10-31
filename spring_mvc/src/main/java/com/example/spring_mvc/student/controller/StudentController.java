package com.example.spring_mvc.student.controller;

import com.example.spring_mvc.student.dto.GetStudentResponse;
import com.example.spring_mvc.student.dto.GetStudentsResponse;
import com.example.spring_mvc.student.dto.PutStudentRequest;
import com.example.spring_mvc.student.mapper.StudentMapper;
import com.example.spring_mvc.student.service.impl.StudentDefaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
public class StudentController {
    public final String Student_PATH = "/api/students";
    public final String Student_PATH_ID = Student_PATH +"/{StudentId}";
    private final StudentMapper StudentMapper;
    private final StudentDefaultService StudentService;

    @GetMapping(Student_PATH)
    public ResponseEntity<GetStudentsResponse> getStudents(){
        return ResponseEntity.ok(GetStudentsResponse.builder().students(StudentService.findAll().stream().map(StudentMapper::StudentToStudentDto).toList()).build());
    }
    @GetMapping(Student_PATH_ID)
    public ResponseEntity<GetStudentResponse> getStudent(@PathVariable("StudentId") UUID uuid){
        try{
           return ResponseEntity.ok(StudentService.find(uuid).map(StudentMapper::StudentToGetStudentResponse).orElseThrow(()->new ResponseStatusException(NOT_FOUND)));
        }
        catch (Exception e){
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
    }
    @PutMapping(Student_PATH_ID)
    public ResponseEntity<Void> putStudent(@PathVariable("StudentId") UUID uuid, @RequestBody PutStudentRequest request){
        StudentService.updateStudentById(uuid, StudentMapper.putStudentRequestToStudent(uuid, request));
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(Student_PATH_ID)
    public ResponseEntity<Void> deleteStudent(@PathVariable("StudentId") UUID uuid){
        StudentService.delete(uuid);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("api/rooms/{id}/students")
    public ResponseEntity<GetStudentsResponse> getStudentInRoom(@PathVariable("id") UUID uuid){
        try{
            return ResponseEntity.ok(GetStudentsResponse.builder().students(StudentService.findRoomStudents(uuid).stream().map(StudentMapper::StudentToStudentDto).toList()).build());
        }
        catch (Exception e){
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
    }
}

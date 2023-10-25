package com.example.spring_mvc;

import com.example.spring_mvc.entities.Room;
import com.example.spring_mvc.entities.Student;
import com.example.spring_mvc.service.impl.RoomDefaultService;
import com.example.spring_mvc.service.impl.StudentDefaultService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class CommandLineRunnerApp implements CommandLineRunner {
    private final RoomDefaultService roomService;
    private final StudentDefaultService studentService;

    @Override
    public void run(String... args) throws Exception {
        try (Scanner myScanner = new Scanner(System.in);){
            while (true){
                showCommands();
                switch (myScanner.nextInt()){
                    case 1 -> roomService.findAll().forEach(System.out::println);
                    case 2 -> studentService.findAll().forEach(System.out::println);
                    case 3 -> addNewRoom(myScanner);
                    case 4 -> deleteRoom(myScanner);
                    default -> throw new Exception();
                }
            }
        } catch (Exception e){
            System.out.println("Bye");
        }
    }
    private void showCommands(){
        System.out.println("\n1 -> Show all rooms");
        System.out.println("2 -> Show all students");
        System.out.println("3 -> Add new room");
        System.out.println("4 -> Delete room");
        System.out.println("Else -> Close\n");

    }
    private void addNewRoom(Scanner myScanner){
            System.out.println("Podaj nazwe pokoju");
            String name = myScanner.next();
            System.out.println("Podaj liczbe studentow");
            int number = myScanner.nextInt();
            Room room = Room.builder()
                    .id(UUID.randomUUID())
                    .name(name)
                    .bedsNumber(number)
                    .build();
            roomService.create(room);
            List<Student> students = studentService.findAll();
            for(int i = 0 ; i < number ;i++) {
                room.addStudent(students.get(i));
            }
    }
    private void deleteRoom(Scanner myScanner){

    }
}

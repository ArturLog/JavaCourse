package com.example.spring_mvc.dataInitializer;

import com.example.spring_mvc.room.entity.Room;
import com.example.spring_mvc.student.entity.Student;
import com.example.spring_mvc.room.service.impl.RoomDefaultService;
import com.example.spring_mvc.student.service.impl.StudentDefaultService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final static List<String> roomsNames = List.of(
            "1A", "1B", "1C", "1D", "2A", "2B", "2C", "2D", "3A", "3B",
            "3C", "3D", "4A", "4B", "4C", "4D", "5A", "5B", "5C", "5D",
            "6A", "6B", "6C", "6D", "7A", "7B", "7C", "7D", "8A", "8B",
            "8C", "8D", "9A", "9B", "9C", "9D", "10A", "10B", "10C", "10D",
            "11A", "11B", "11C", "11D", "12A", "12B", "12C", "12D", "13A", "13B",
            "13C", "13D", "14A", "14B", "14C", "14D", "15A", "15B", "15C", "15D",
            "16A", "16B", "16C", "16D", "17A", "17B", "17C", "17D", "18A", "18B",
            "18C", "18D", "19A", "19B", "19C", "19D", "20A", "20B", "20C", "20D",
            "1A", "1B", "1C", "1D", "2A", "2B", "2C", "2D", "3A", "3B",
            "3C", "3D", "4A", "4B", "4C", "4D", "5A", "5B", "5C", "5D"
    );
    private final static List<String> studentNames = List.of(
            "Jan", "Zbigniew", "Robert", "Marcin", "Bob",
            "Anna", "Maria", "Krzysztof", "Andrzej", "Wojciech",
            "Małgorzata", "Agnieszka", "Katarzyna", "Piotr", "Tomasz",
            "Barbara", "Dorota", "Krystyna", "Ewa", "Sylwia",
            "Marek", "Jacek", "Tadeusz", "Adam", "Mariusz",
            "Iwona", "Joanna", "Beata", "Monika", "Marta",
            "Alicja", "Aleksandra", "Patrycja", "Kamil", "Sebastian",
            "Magdalena", "Aleksander", "Ewelina", "Grażyna", "Renata",
            "Marian", "Henryk", "Zofia", "Helena", "Elżbieta",
            "Karolina", "Karol", "Radosław", "Dariusz", "Robert",
            "Izabela", "Klaudia", "Jolanta", "Kinga", "Kornelia",
            "Zenon", "Jerzy", "Cezary", "Kazimierz", "Józef",
            "Wanda", "Janina", "Marzena", "Natalia", "Aneta",
            "Władysław", "Lech", "Adrian", "Tadeusz", "Stanisław",
            "Dawid", "Jolanta", "Jagoda", "Anita", "Sandra",
            "Krystian", "Katarzyna", "Dawid", "Aneta", "Agata",
            "Marzena", "Paweł", "Jarosław", "Łukasz", "Ryszard",
            "Ewa", "Karina", "Nikodem", "Kaja", "Bartosz",
            "Artur", "Jadwiga", "Edyta", "Kazimierz", "Eliza",
            "Mateusz", "Marcel", "Rafał", "Julia", "Kasia",
            "Zbigniew", "Marta", "Anita", "Magdalena", "Patryk"
    );

    private final static List<String> studentSurnames = List.of(
            "Nowak", "Kowalski", "Wiśniewski", "Dąbrowski", "Lewandowski",
            "Wójcik", "Kamiński", "Kowalczyk", "Zieliński", "Szymański",
            "Woźniak", "Kozłowski", "Jankowski", "Mazur", "Kwiatkowski",
            "Kaczmarek", "Piotrowski", "Grabowski", "Nowakowski", "Pawłowski",
            "Michalski", "Adamczyk", "Dudek", "Zając", "Wieczorek",
            "Jabłoński", "Król", "Majewski", "Olszewski", "Stępień",
            "Jaworski", "Malinowski", "Pawlak", "Górski", "Sikora",
            "Walczak", "Baran", "Rutkowski", "Michalak", "Szewczyk",
            "Ostrowski", "Tomaszewski", "Witkowski", "Zalewski", "Sawicki",
            "Sobczak", "Czarnecki", "Kubiak", "Kurowski", "Kalinowski",
            "Lis", "Maciejewski", "Urbański", "Krupa", "Kowalewski",
            "Wolski", "Baranowski", "Jasiński", "Serafin", "Rogowski",
            "Rybak", "Gajewski", "Marczak", "Brzeziński", "Kaczmarczyk",
            "Bak", "Borkowski", "Szczepański", "Sadowski", "Leszczyński",
            "Milewski", "Borowski", "Czerwiński", "Frankowski", "Lipiński",
            "Bartosz", "Kucharski", "Kłos", "Dubois", "Laskowski",
            "Rut", "Rak", "Zawisza", "Wrona", "Ławniczak",
            "Duda", "Zielińska", "Jaworska", "Kalinowska", "Gajewska",
            "Czerwińska", "Lipińska", "Bartosz", "Kucharska", "Kłos",
            "Dubois", "Laskowska", "Rut", "Rak", "Zawisza", "Wrona"
    );


    private final RoomDefaultService roomService;
    private final StudentDefaultService studentService;

    @PostConstruct
    public void initializerData(){
        Random rand = new Random();

        for (String n : roomsNames) {
            int bedNumber = rand.nextInt(4) + 1;
            Room room = Room.builder()
                    .id(UUID.randomUUID())
                    .name(n)
                    .bedsNumber(bedNumber)
                    .build();
            roomService.create(room);
            for (int i = 0; i< bedNumber; i++) {
                int studentNumber = rand.nextInt(studentNames.size() - 5);
                Student student = Student.builder()
                        .id(UUID.randomUUID())
                        .name(studentNames.get(studentNumber))
                        .surname(studentSurnames.get(studentNumber))
                        .room(room)
                        .build();
                room.addStudent(student);
                studentService.create(student);
            }
        }
    }

}

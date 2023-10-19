package org.example;

import org.example.entities.Room;
import org.example.entities.Student;
import org.example.entities.StudentDto;

import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    private final static List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    private final static List<String> names = List.of("Jan Kowal", "Zbigniew Stonoga", "Robert Lewandowski", "Marcin Markowski", "Bob Nowak");

    public static void main(String[] args) throws FileNotFoundException{
        Set<Room> rooms = new HashSet<>();
        Random rand = new Random();

        for (Integer n : numbers){
            rooms.add(Room.builder()
                    .roomNumber(n)
                    .bedsNumber(rand.nextInt(4)+1)
                    .build());
        }

        for (Room r : rooms){
            for(int i = 0;i < rand.nextInt(r.getBedsNumber() + 1); i++){
                r.addStudent(Student.builder()
                        .room(r)
                        .name(names.get(rand.nextInt(names.size())))
                        .id(rand.nextInt(10000) + 10000)
                        .build());
            }
        }

        // 2
//        rooms.forEach(f -> {
//            System.out.println(f);
//            f.getStudents()
//                    .forEach(System.out::println);
//        });

        // 3

        Set<Student> students = rooms.stream()
                .map(Room::getStudents)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
//
//        students.stream()
//                .forEach(System.out::println);

        // 4
//
//        students.stream()
//                .filter(f -> f.getId() >= 15000)
//                .sorted(Comparator.comparing(Student::getName))
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);

        // 5

        List<StudentDto> studentdtos = students.stream()
                                                .map(el -> StudentDto.builder()
                                                        .room(el.getRoom().toString())
                                                        .name(el.getName())
                                                        .id(el.getId())
                                                        .build())
                                                .toList();
        //studentsdtos.stream().forEach(System.out::println);

        // 6
        File file = new File("ex6.bin");

        //save
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(students);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Set<Student> read = new HashSet<>();

        //read
        FileInputStream fstream = new FileInputStream(file);
        try {
            ObjectInputStream ostream = new ObjectInputStream(fstream);

            Object obj;
            obj = ostream.readObject();
            read = (HashSet<Student>) obj;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        read.forEach(System.out::println);

        // 7
        int roomNumber = 5;
        int customThreadsNumber = 5;
        ForkJoinPool pool = new ForkJoinPool(customThreadsNumber);
        // write students in room

        pool.submit(
                () -> rooms.parallelStream()
                        .filter(f -> f.getRoomNumber() < roomNumber)
                        .sorted()
                        .forEachOrdered(r -> r.getStudents()
                                .forEach(System.out::println)));


        pool.shutdown();
        try {
            pool.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

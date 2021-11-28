package ru.mephi.seminar6.homework.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class P02NioRead {

    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("./src/ru/mephi/seminar6/homework/task1/hamlet.txt"))) {

            System.out.println("=== Entire File ===");
            //print out file here
            lines.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

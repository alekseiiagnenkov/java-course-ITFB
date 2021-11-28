package ru.mephi.seminar6.homework.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P02NioRead {

    public static void main(String[] args) {
        try (BufferedReader bReader = new BufferedReader(new FileReader("./src/ru/mephi/seminar6/homework/task1/hamlet.txt"))) {

            System.out.println("=== Entire File ===");
            //print out file here
            bReader
                    .lines()
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

package ru.mephi.seminar6.homework.task1;

import java.io.*;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;


public class P03NioReadAll {

    public static void main(String[] args) {

        List<String> fileArr = null;
        Path file = Paths.get("./src/ru/mephi/seminar6/homework/task1/hamlet.txt");

        try {
            // Read file into array here
            if (Files.notExists(file, LinkOption.NOFOLLOW_LINKS)) {
                throw new FileNotFoundException();
            }
            if (!Files.isReadable(file)) {
                throw new SecurityException("The file cannot be read!");
            }

            fileArr = Files.readAllLines(file);

            System.out.println("\n=== Rosencrantz ===");
            // Filter for Ros. here
            fileArr.stream()
                    .filter(line -> line.trim().startsWith("Ros."))
                    .forEach(System.out::println);


            System.out.println("\n=== Guildenstern ===");
            // Filter for Guil. here
            fileArr.stream()
                    .filter(line -> line.trim().startsWith("Guil."))
                    .forEach(System.out::println);


        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

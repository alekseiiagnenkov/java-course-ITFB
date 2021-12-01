package ru.mephi.seminar6.homework.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirFind {
    public static void main(String[] args) {

        try (Stream<Path> files = Files.list(Paths.get(args[0]))) { // Add try with resources

            System.out.println("\n=== Find all dirs ===");
            // Print out directory list here
            files.forEach(System.out::println);

        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

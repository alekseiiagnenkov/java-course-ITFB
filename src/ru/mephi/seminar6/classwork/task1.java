package ru.mephi.seminar6.classwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class task1 {

    static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String str = in.nextLine();

        try (BufferedReader bReader = new BufferedReader(new FileReader(args[0]))) {
            bReader
                    .lines()
                    .filter(line -> line.trim().equals(str))
                    .forEach(line -> count++);
            System.out.println("Result: " + count);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}

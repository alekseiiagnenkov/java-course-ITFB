package ru.mephi.seminar2.classwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author https://github.com/alekseiiagnenkov<br><br>
 * Get strings as input to string<br>.
 * Count the number of identical lines entered<br>.
 */
public class lab1 {
    public static void main(String[] args) {
        System.out.print("Enter the number of lines:");

        int size = -1;
        do {
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                size = in.nextInt();
            }
        } while (size == -1);

        String[] str = new String[size];
        Scanner in = new Scanner(System.in);
        for( int i=0; i< size; i++){
            str[i] = in.nextLine();
        }

        Map<String, Integer> map = new HashMap<>();
        for (String s : str) {
            int count = map.getOrDefault(s, -1);

            if (count == -1)
                map.put(s, 0);
            else
                map.put(s, count + 1);
        }

        System.out.print(map);
    }
}

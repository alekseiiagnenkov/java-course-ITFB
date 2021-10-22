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

        System.out.print("Enter a string:");

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        Map<String, Integer> map = new HashMap<>();
        for (String s : str.split(" ")) {
            int count = map.getOrDefault(s, -1);

            if (count == -1)
                map.put(s, 1);
            else
                map.put(s, count + 1);
        }

        System.out.print(map);
    }
}

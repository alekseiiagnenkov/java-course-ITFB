package ru.mephi.seminar2.classwork;

import java.util.*;


/**
 * @author https://github.com/alekseiiagnenkov<br><br>
 * @see lab1
 * .<br>Changed: Output is in the same order as input.
 */
public class lab2 {

    public static void main(String[] args) {
        System.out.print("Enter a string:");

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        Map<String, Integer> set = new LinkedHashMap<>();

        for (String s : str.split(" ")) {
            int count = set.getOrDefault(s, -1);

            if (count == -1)
                set.put(s, 1);
            else
                set.put(s, count + 1);
        }
        System.out.print(set);
    }
}

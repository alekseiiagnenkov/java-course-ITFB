package ru.mephi.seminar2.classwork;

import java.util.*;


/**
 * @author https://github.com/alekseiiagnenkov<br><br>
 * @see lab1
 * .<br>Changed: Output is in the same order as input.
 */
public class lab2 {
    //TODO разделялись пробелом
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

        Map<String, Integer> set = new LinkedHashMap<>();

        for (String s : str) {
            int count = set.getOrDefault(s, -1);

            if (count == -1)
                set.put(s, 1);
            else
                set.put(s, count + 1);
        }
        System.out.print(set);
    }
}

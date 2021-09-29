package ru.mephi.seminar2.classwork;

import java.util.*;

public class lab2 {
    public static void main(String[] args) {
        Map<String, Integer> set = new LinkedHashMap<>();
        String[] str = {"a", "b", "a", "ab", "a"};

        for (String s : str) {
            int count = set.getOrDefault(s, -1);

            if (count == -1)
                set.put(s, 0);
            else
                set.put(s, count + 1);
        }
        System.out.print(set);
    }
}

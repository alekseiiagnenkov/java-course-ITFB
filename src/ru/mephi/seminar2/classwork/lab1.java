package ru.mephi.seminar2.classwork;

import java.util.HashMap;
import java.util.Map;

public class lab1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String[] str = {"a", "b", "a", "ab", "a"};

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

package ru.mephi.seminar6.homework.task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class P04NioReadAll {

    static long wordCount;
    static long index = 0, Index = 0;
    static String Str, str;

    /**
     * считаем количество Str или str в строке
     */
    public static Consumer<String> createConsumer() {

        Consumer<String> findStr = line -> {
            String it = line;
            do {
                long index;
                P04NioReadAll.index = it.indexOf(str);
                Index = it.indexOf(Str);

                if (Math.max(P04NioReadAll.index, Index) == -1) {
                    break;
                } else if (P04NioReadAll.index == -1) {
                    index = Index;
                } else if (Index == -1) {
                    index = P04NioReadAll.index;
                } else {
                    index = Math.min(P04NioReadAll.index, Index);
                }

                wordCount++;
                it = it.substring((int) index + 1);
            } while (true);

        };

        return findStr;
    }

    public static void main(String[] args) {

        Path file = Paths.get("./src/ru/mephi/seminar6/homework/task1/hamlet.txt");
        List<String> fileArr = null;
        try {
            // Read fileinto array here
            if (Files.notExists(file, LinkOption.NOFOLLOW_LINKS)) {
                throw new FileNotFoundException();
            }
            if (!Files.isReadable(file)) {
                throw new SecurityException("The file cannot be read!");
            }

            fileArr = Files.readAllLines(file);

            Consumer<String> findStr = createConsumer();

            System.out.println("\n=== Lord Count ===");
            wordCount = 0; // Replace with your pipeline
            Str = "Lord";
            str = "lord";
            fileArr.stream()
                    .filter(line -> line.contains(str) || line.contains(Str))
                    .forEach(findStr);
            System.out.println("Word count: " + wordCount);

            System.out.println("\n=== Prison Count ===");
            wordCount = 0; // Replace with your pipeline
            Str = "Prison";
            str = "prison";
            fileArr.stream()
                    .filter(line -> line.contains(str) || line.contains(Str))
                    .forEach(findStr);
            System.out.println("Word count: " + wordCount);


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

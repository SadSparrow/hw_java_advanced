package org.sparrow.tasks.five;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;
//test
public class Main {

    public static void main(String[] args) {
        Map<String, Integer> wordStatistics = new TreeMap<>();

        try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/text.txt"), StandardCharsets.UTF_8)) {

            stream.forEach(line -> Arrays.asList(line.toLowerCase(Locale.ROOT).split(" "))
                    .forEach(word -> wordStatistics.merge(word, 1, Integer::sum)));

            System.out.println("Статистика:");
            wordStatistics.forEach((k, v) -> System.out.printf("Слово [%s] встречается в файле %d раз(-а)%n", k, v));

            String wordMaxRepeat = Collections.max(wordStatistics.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            System.out.printf("Слово с максимальным количеством повторений: %n%s - встречается %d раз(-а)",
                    wordMaxRepeat, wordStatistics.get(wordMaxRepeat));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

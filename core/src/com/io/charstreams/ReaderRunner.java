package com.io.charstreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

// from dmdev
public class ReaderRunner {
  public static void main(String[] args) {
    // Вариант 1 - с использование java.io
        /*
        File file = Path.of("resources", "poem.txt").toFile();
        try (BufferedReader fileReader = new BufferedReader(
            new FileReader(file, StandardCharsets.UTF_8)))
        {
            String collect = fileReader.lines()
                .collect(Collectors.joining("\n"));
            System.out.println(collect);
            System.out.println("\nSize = " + collect.length() + " chars.");
        } catch (IOException ignored) {}
         */

    // Вариант 2 - с использованием java.io
        /*
        Path path = Path.of("resources", "poem.txt");
        try (BufferedReader fileReader = Files.newBufferedReader(path))
        {
            String collect = fileReader.lines()
                .collect(Collectors.joining("\n"));
            System.out.println(collect);
            System.out.println("\nSize = " + collect.length() + " chars.");
        } catch (IOException ignored) {}
         */
    // Вариант 3 - с использованием java.nio
    Path path = Path.of("resources", "poem.txt");
    try (Stream<String> lines = Files.lines(path)) {
      // будем считывать строки по чуть-чуть, а не разом
      lines.forEach(System.out::println);
    } catch (IOException ignored) {
    }

    // Вариант 4 - вывести все строки разом
    try {
      List<String> allLines = Files.readAllLines(path);
      allLines.forEach(System.out::println);
    } catch (IOException ignored) {
    }

  }
}

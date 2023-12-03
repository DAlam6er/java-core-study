package com.nio.dmdev;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 * 5. Задан файл с java-кодом. Прочитать текст программы из файла и
 * записать в другой файл в обратном порядке символы каждой
 * строки.
 */
public class Task5 {
  public static void main(String[] args) {
    // // com.io.tasks.Task4.!java
    Path path = Path.of("src", "com", "io", "tasks", "Task4.!java");
    Path result = Path.of("resources", "Task4.!java");

    try (Stream<String> lines = Files.lines(path);
         BufferedWriter bufferedWriter =
             Files.newBufferedWriter(result, APPEND, CREATE)) {
      lines.map(StringBuilder::new)
          .map(StringBuilder::reverse)
          .forEach(getConsumer(bufferedWriter));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static Consumer<StringBuilder> getConsumer(BufferedWriter bufferedWriter) {
    return line -> {
      try {
        bufferedWriter.write(line.toString());
        bufferedWriter.newLine();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    };
  }
}

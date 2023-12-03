package com.io.charstreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterRunner {
  public static void main(String[] args) {
    // Вариант 1 - с использование java.io
        /*
        File file = Path.of("resources", "writer.txt").toFile();
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(
            file, StandardCharsets.UTF_8,true)))
        {
            fileWriter.append("Hello World!");
            fileWriter.newLine();
            fileWriter.append("Java");
        } catch (IOException ignored) {}
         */

    // Вариант 2 - с использованием java.nio
        /*
        Path path = Path.of("resources", "writer.txt");
        try (BufferedWriter fileWriter = Files.newBufferedWriter(path)) {
            fileWriter.append("Hello World!");
            fileWriter.newLine();
            fileWriter.append("Java");
        } catch (IOException ignored) {}
         */

    // Вариант 3 - с использованием java.nio
    Path path = Path.of("resources", "writer.txt");
    try {
      Files.write(path, List.of("Hello World!", "Java"));
    } catch (IOException ignored) {
    }
  }
}

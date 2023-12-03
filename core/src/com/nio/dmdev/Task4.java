package com.nio.dmdev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 4. Задан файл с java-кодом. Прочитать текст программы из файла и
 * все слова public в объявлении атрибутов и методов класса заменить
 * на слово private. Результат сохранить в другой заранее созданный
 * файл.
 */
public class Task4 {
  public static void main(String[] args) {
    // com.io.tasks.Task3.java
    Path path = Path.of("src", "com", "io", "tasks", "Task3.java");
    try {
      // Представим файл в виде одной строки
      String stringValue = Files.readString(path);
      String result = stringValue.replace("public", "private");

      Path resultPath = Path.of("resources", "Task3.java");
      // Записываем строку в файл
      Files.writeString(resultPath, result);
    } catch (IOException ignored) {
    }
  }
}

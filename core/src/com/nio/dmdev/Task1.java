package com.nio.dmdev;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * 1. Задан файл с текстом, найти и вывести в консоль все слова,
 * начинающиеся с гласной буквы.
 */
public class Task1 {
  public static final String VOWELS = "ауоиэыяюеё";

  public static void main(String[] args) {
    Path path = Path.of("resources", "poem.txt");
    try (Scanner scanner = new Scanner(path)) {
      while (scanner.hasNext()) {
        String word = scanner.next();
        char firstSymbol = word.charAt(0);
        if (VOWELS.indexOf(firstSymbol) != -1) {
          System.out.println(word);
        }
      }
    } catch (IOException ignored) {
    }
  }
}

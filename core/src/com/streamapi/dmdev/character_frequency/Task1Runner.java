package com.streamapi.dmdev.character_frequency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

/**
 * Задан файл со стихотворением.
 * Определить частоту повторяемости всех букв в стихотворении, игнорируя регистр.
 * Вывести результат в файл в виде:
 * а - 15
 * б - 7
 * и т.д.
 */
public class Task1Runner {
  public static void main(String[] args) throws IOException {
    Path path = Path.of("resources", "poem.txt");
    Map<Character, Integer> characterFrequency = CharacterHelper.calcFrequency(path);

    Path result = Path.of("resources", "task-1.result.txt");
    Files.write(
        result, CharacterHelper.toListRepresentation(characterFrequency),
        CREATE, TRUNCATE_EXISTING);
  }
}

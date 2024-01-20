package com.streamapi.warburton.chap03;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Пусть дан список строк List<String>
 * Найдите в нем строку, содержащую максимальное число строчных букв
 * Чтобы код правильно работал, когда входной список пуст, можете возвращать объект
 * типа Optional<String>
 */
public class Task07 {
  public static void main(String[] args) {
    List<String> strings = List.of(
        "C2H5OH",
        "Hello, cruel world",
        "CH3CH2CH2CH3",
        "RSFSR"
    );
    Optional<String> stringWithMaxCapitalLetters = getStringWithMaxCapitalLetters(strings);
    stringWithMaxCapitalLetters.ifPresent(System.out::println);
  }

  public static Optional<String> getStringWithMaxCapitalLetters(List<String> strings) {
    return strings.stream()
        .max(Comparator.comparingLong(Task06::countLowerLetters));
  }
}

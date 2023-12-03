package com.collections.dmdev;

import java.util.HashSet;
import java.util.List;

/**
 * 2. Написать метод countUnique, который принимает целочисленный
 * списк в качестве параметра и возвращает количество уникальных
 * целых чисел в этом списке.
 * При получении пустого списка метод должен возвращать 0.
 * Пример:
 * [3, 7, 3, -1, 2, 3, 7, 2, 15, 15] вернёт 5.
 */
public class CountUniqueNumbers {
  public static void main(String[] args) {
    List<Integer> itegers = List.of(3, 7, 3, -1, 2, 3, 7, 2, 15, 15);
    System.out.println(countUnique(itegers));
  }

  private static int countUnique(List<Integer> list) {
    return new HashSet<>(list).size();
  }
}

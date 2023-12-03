package com.collections.dmdev;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Написать метод, который принимает целочисленный список и возвращает
 * целочисленный список только с нечетными значениями.
 */
public class OnlyOddNumbers {
  public static void main(String[] args) {
    List<Integer> list = List.of(1, 3, 6, 8, 9, 13, 20);
    List<Integer> result = removeEven(list);
    System.out.println(result);
  }

  private static List<Integer> removeEven(List<Integer> list) {
    // 1. List.of() и Arrays.asList() возвращают неизменяемые коллекции,
    // т.е. нельзя добавлять и удалять из них элементы
    //
    // 2. Нельзя во время итерирования изменять коллекцию, даже если она изменяемая
    // будет выброшено исключение java.utilConcurrentModificationException
        /*
        for (Integer value : list) {
            if (value % 2 == 0) {
                list.remove(value);
            }
        }
        */
    // 3. Правилами хорошего тона является не изменять параметры методов.
    // то есть возвращаемое значение следует делать новым объектом.

    List<Integer> result = new ArrayList<>();
    for (Integer value : list) {
      if (value % 2 != 0) {
        result.add(value);
      }
    }
    return result;
  }
}

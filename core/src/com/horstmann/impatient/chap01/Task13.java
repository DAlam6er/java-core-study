package com.horstmann.impatient.chap01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Напишите программу, выбирающую и выводящую лотерейную комбинацию из шести отдельных чисел
 * в пределах от 1 до 49. Чтобы выбрать шесть отдельных чисел, начните по списочного массива,
 * заполняемого числами от 1 до 49. Выберите произвольный индекс и удалите элемент массива.
 * Повторите эти действия шесть раз подряд.
 * Выведите полученный результат в отсортированном порядке.
 */
public class Task13 {
  private static final Integer START_VALUE = 1;
  private static final Integer FINAL_VALUE = 49;
  private static final Integer COMBINATION_SIZE = 6;
  public static void main(String[] args) {
    List<Integer> integers = fillList();
    List<Integer> combination = new ArrayList<>(COMBINATION_SIZE);
    for (int i = 0; i < 6; i++) {
      combination.add(integers.remove(new Random().nextInt(integers.size())));
    }
    Collections.sort(combination);
    System.out.println(integers);
    System.out.println("Выигрышная комбинация: " + combination);
  }

  private static List<Integer> fillList() {
    List<Integer> newList = new ArrayList<>(FINAL_VALUE);
    for (int i = 0; i < FINAL_VALUE; ) {
      int newNumber = new Random().nextInt(FINAL_VALUE) + START_VALUE;
      if (!newList.contains(newNumber)) {
        newList.add(newNumber);
        i++;
      }
    }
    return newList;
  }
}

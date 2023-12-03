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
  public static void main(String[] args) {
    List<Integer> integers = fillList(1, 49);
    List<Integer> combination = new ArrayList<>(6);
    for (int i = 0; i < 6; i++) {
      combination.add(integers.remove(new Random().nextInt(integers.size())));
    }
    Collections.sort(combination);
    System.out.println(integers);
    System.out.println("Выигрышная комбинация: " + combination);
  }

  private static List<Integer> fillList(int startValue, int endValue) {
    List<Integer> newList = new ArrayList<>(endValue);
    for (int i = 0; i < endValue; ) {
      int newNumber = new Random().nextInt(endValue) + 1;
      if (!newList.contains(newNumber)) {
        newList.add(newNumber);
        i++;
      }
    }
    return newList;
  }
}

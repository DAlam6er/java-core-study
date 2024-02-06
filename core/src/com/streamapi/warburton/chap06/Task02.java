package com.streamapi.warburton.chap06;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Все элементы списка перемножаются, а результат умножается на 5.
 * Последовательная версия этого кода работает правильно, но при распараллеливании
 * появляется ошибка. Преобразуйте эту программу в параллельную с помощью потоковой библиотеки
 * и исправьте ошибку
 */
public class Task02 {
  public static void main(String[] args) {
    System.out.println(sequentialMultiplyThrough(asList(1, 2, 3)));
    System.out.println(parallelMultiplyThrough(asList(1, 2, 3)));
  }

  public static int sequentialMultiplyThrough(List<Integer> linkedListOfNumbers) {
    return linkedListOfNumbers.stream()
        .reduce(5, (acc, x) -> x * acc);
  }

  private static int parallelMultiplyThrough(List<Integer> numbers) {
    return 5 * numbers.parallelStream()
        .reduce(1, (acc, x) -> x * acc);
  }
}

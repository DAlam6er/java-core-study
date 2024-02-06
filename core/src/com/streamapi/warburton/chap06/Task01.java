package com.streamapi.warburton.chap06;

import java.util.stream.IntStream;

/**
 * Написать метод последовательного суммирования квадратов элементов списка
 * с использованием параллельных потоков
 */
public class Task01 {
  public static void main(String[] args) {
    System.out.println(sequentialSumOfSquares(IntStream.range(1, 4)));
    System.out.println(parallelSumOfSquares(IntStream.range(1, 4)));
  }

  private static int parallelSumOfSquares(IntStream range) {
    return range.parallel()
        .map(x -> x * x)
        .sum();
  }

  public static int sequentialSumOfSquares(IntStream range) {
    return range.map(x -> x * x)
        .sum();
  }
}

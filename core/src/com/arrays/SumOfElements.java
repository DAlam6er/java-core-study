package com.arrays;

/**
 * Определить сумму элементов целочисленного массива,
 * расположенных между минимальным и максимальным значениями.
 */
public class SumOfElements {
  public static void main(String[] args) {
    int[] values = {1, 10, 3, 5, 6, 4, 0, 7};
    System.out.println(sumBetweenMinAndMax(values));
  }

  public static long sumBetweenMinAndMax(int[] values) {
    int minIndex = findMinIndex(values);
    int maxIndex = findMaxIndex(values);
    // меняем местами индексы при необходимости для правильного результата
    if (minIndex > maxIndex) {
      minIndex ^= maxIndex;
      maxIndex ^= minIndex;
      minIndex ^= maxIndex;
    }
    int result = 0;
    for (int i = minIndex + 1; i < maxIndex; i++) {
      result += values[i];
    }
    return result;
  }

  public static int findMinIndex(int[] values) {
    int minIndex = 0;
    for (int i = 0; i < values.length; i++) {
      if (values[minIndex] > values[i]) {
        minIndex = i;
      }
    }
    return minIndex;
  }

  public static int findMaxIndex(int[] values) {
    int maxIndex = 0;
    for (int i = 0; i < values.length; i++) {
      if (values[maxIndex] < values[i]) {
        maxIndex = i;
      }
    }
    return maxIndex;
  }
}

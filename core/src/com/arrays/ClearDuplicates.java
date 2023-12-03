package com.arrays;

import java.util.Arrays;

/**
 * Написать программу, удаляющую все повторяющиеся целые числа из массива
 * и печатающую результат.
 * Массив должен использоваться тот же самый.
 * На место удаленных элементов ставить цифру 0.
 */
public class ClearDuplicates {
  public static void main(String[] args) {
    int[] matrix = new int[]{12, 9, 3, 9, 12, 4, 3, 4};
    System.out.println("Исходный   массив: " + Arrays.toString(matrix));
    clearDuplicates(matrix);
    System.out.println("Измененный массив: " + Arrays.toString(matrix));
  }

  public static void clearDuplicates(int[] m) {
    for (int i = 0; i < m.length - 1; i++) {
      for (int j = i + 1; j < m.length; j++) {
        if (m[j] == m[i]) m[j] = 0;
      }
    }
  }
}

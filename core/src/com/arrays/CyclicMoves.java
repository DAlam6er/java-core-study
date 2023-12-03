package com.arrays;

import java.util.Arrays;

/**
 * Напишите программу, которая циклически сдвигает элементы массива
 * a. вправо на одну позицию, и печатает результат.
 * b. влево  на одну позицию, и печатает результат.
 */
public class CyclicMoves {
  public static void main(String[] args) {
    int[] matrix = new int[]{1, 2, 3, 4, 5};
    System.out.println("Исходный массив: " + Arrays.toString(matrix));
    int[] movedRight = cyclicMoveRight(matrix);
    System.out.println("Массив, сдвинутый вправо на 1 позицию: "
                       + Arrays.toString(movedRight));
    int[] movedLeft = cyclicMoveLeft(matrix);
    System.out.println("Массив, сдвинутый влево  на 1 позицию: "
                       + Arrays.toString(movedLeft));
  }

  // 1 2 3 4 5
  // -->
  // 5 1 2 3 4
  private static int[] cyclicMoveRight(int[] matrix) {
    int[] m = matrix.clone();
    int temp = m[m.length - 1];
    for (int i = m.length - 1; i > 0; i--) {
      m[i] = m[i - 1];
    }
    m[0] = temp;
    return m;
  }

  // 1 2 3 4 5
  // <--
  // 2 3 4 5 1
  private static int[] cyclicMoveLeft(int[] matrix) {
    int[] m = matrix.clone();
    int temp = m[0];
    for (int i = 0; i < m.length - 1; i++) {
      m[i] = m[i + 1];
    }
    m[m.length - 1] = temp;
    return m;
  }
}

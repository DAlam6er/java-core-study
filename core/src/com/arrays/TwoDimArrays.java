package com.arrays;

import java.util.Arrays;

/**
 * Написать:
 * a. метод equals, который определяет, равны ли между собой
 * соответствующие элементы двухмерных массивов
 * b. метод linearize, который принимает в качестве параметра двумерный массив
 * и возвращает одномерный массив со всеми элементами двумерного
 */
public class TwoDimArrays {
  public static void main(String[] args) {
    int[][] values1 = {
        {1, 2, 3},
        {5, 2, 8},
        {9, 10},
    };
    int[][] values2 = {
        {1, 2, 3},
        {5, 2, 8},
        {9, 10},
    };
    boolean result = equals(values1, values2);
    System.out.println(result);
    System.out.println(Arrays.toString(linearize(values1)));
  }

  public static boolean equals(int[][] values1, int[][] values2) {
    if (values1.length != values2.length) {
      return false;
    }

    for (int i = 0; i < values1.length; i++) {
      int[] row1 = values1[i];
      int[] row2 = values2[i];
      if (row1.length != row2.length) {
        return false;
      }
      for (int j = 0; j < row1.length; j++) {
        if (row1[j] != row2[j]) {
          return false;
        }
      }
    }
    return true;
  }

  public static int[] linearize(int[][] matrix) {
    int size = 0;
    for (int i = 0; i < matrix.length; i++) {
      size += matrix[i].length;
    }
    int[] linear = new int[size];
    int k = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        linear[k++] = matrix[i][j];
      }
    }
    return linear;
  }
}

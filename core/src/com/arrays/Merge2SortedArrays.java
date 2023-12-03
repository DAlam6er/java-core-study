package com.arrays;

import java.util.Arrays;

// FROM javabasecourse
public class Merge2SortedArrays {
  public static void main(String[] args) {
    int[] m1 = new int[]{1, 2, 3, 4, 5, 7};
    int[] m2 = new int[]{3, 4, 5, 6};
    System.out.println(Arrays.toString(mergeAndSort(m1, m2)));
  }

  /**
   * Merges two given sorted arrays into one sorted
   *
   * @param a1 first sorted array
   * @param a2 second sorted array
   * @return new array containing all elements from a1 and a2, sorted
   */
  public static int[] mergeAndSort(int[] a1, int[] a2) {
    if (a1.length == 0) return a2;
    if (a2.length == 0) return a1;

    int i = 0, j = 0, k = 0;
    int[] res = new int[a1.length + a2.length];

    // Заполняем результирующий массив, пока не закончится любой из исходных
    while (i < a1.length && j < a2.length) {
      res[k++] = a1[i] < a2[j] ? a1[i++] : a2[j++];
    }

    // Дополняем результирующий массив элементами из большего из исходных массивов
    if (i < a1.length) {
      System.arraycopy(a1, i, res, k, a1.length - i);
    } else if (j < a2.length) {
      System.arraycopy(a2, j, res, k, a2.length - j);
    }

    return res;
  }
}

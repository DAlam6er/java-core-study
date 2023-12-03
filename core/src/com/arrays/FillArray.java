package com.arrays;

/**
 * Написать программу, заносящую в массив первые 100 целых чисел,
 * делящихся на 13 или на 17, и печатающую его
 */
public class FillArray {
  public static void main(String[] args) {
    int[] values = new int[100];
    fillArray(values);
    printArray(values);
  }

  public static void fillArray(int[] values) {
    for (int currentValue = 1, currentIndex = 0;
         currentIndex < values.length; currentValue++) {
      if (currentValue % 13 == 0 || currentValue % 17 == 0) {
        values[currentIndex++] = currentValue;
      }
    }
  }

  public static void printArray(int[] values) {
    for (int value : values) {
      System.out.print(value + " ");
    }
    System.out.println();
  }
}

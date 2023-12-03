package com.sortingmethods.javarush;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    Задача: Написать программу, которая вводит с клавиатуры 20 чисел
    и выводит их в убывающем порядке.
 */
public class BubbleSortModified {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int[] array = new int[20];
    for (int i = 0; i < 20; i++) {
      array[i] = Integer.parseInt(reader.readLine());
    }

    sort(array);

    for (int x : array) {
      System.out.println(x);
    }
  }

  public static void sort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      boolean rearranged = false;
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] < array[j + 1]) {
          array[j] ^= array[j + 1];
          array[j + 1] ^= array[j];
          array[j] ^= array[j + 1];
          rearranged = true;
        }
      }
      if (!rearranged) break;
    }
  }
}

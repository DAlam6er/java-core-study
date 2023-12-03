package com.datatypes;

import java.util.Scanner;

/**
 * Написать программу, вычисляющую и отображающую все числа Фибоначчи
 * меньше введённого пользователем целого числа.
 */
public class Fibonacci {
  public static void main(String[] args) {
    System.out.print("Input upper border for Fibonacci: ");
    int limit = Integer.parseInt(new Scanner(System.in).nextLine());
    System.out.println(getFibonacciSeq(limit));
  }

  public static String getFibonacciSeq(int rightBound) {
    int prevFib = 0;
    int curFib = 1;
    int nextFib = prevFib + curFib;
    StringBuilder res = new StringBuilder();
    res.append(prevFib).append(" ").append(curFib);
    while (nextFib < rightBound) {
      nextFib = prevFib + curFib;
      prevFib = curFib;
      curFib = nextFib;
      if (nextFib < rightBound) {
        res.append(" ").append(curFib);
      }
    }
    return res.toString();
  }
}

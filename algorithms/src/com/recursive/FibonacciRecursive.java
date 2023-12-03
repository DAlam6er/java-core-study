package com.recursive;

import java.util.Scanner;

/**
 * Написать программу, вычисляющую и отображающую все числа Фибоначчи
 * меньше введённого пользователем целого числа с помощью рекурсии
 */
public class FibonacciRecursive {
  public static void main(String[] args) {
    System.out.print("Input upper border for FibonacciRecursive: ");
    int upperBound = Integer.parseInt(new Scanner(System.in).nextLine());
    System.out.println(getFibonacciSeq(upperBound));
  }

  public static String getFibonacciSeq(int upperBound) {
    int res = 0;
    int num = 0;
    StringBuilder sb = new StringBuilder();
    while (res < upperBound) {
      res = fibonacci(num);
      num++;
      if (res < upperBound) {
        sb.append(res).append(" ");
      }
    }
    return sb.toString();
  }

  private static int fibonacci(int num) {
    if (num <= 1) return num;
    return fibonacci(num - 2) + fibonacci(num - 1);
  }
}

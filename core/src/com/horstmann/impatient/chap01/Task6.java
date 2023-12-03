package com.horstmann.impatient.chap01;

import java.math.BigInteger;

/**
 * Напишите программу, вычисляющую факториал n! = 1 x 2 x...x n используя класс BigInteger
 * Вычислите факториал числа 1000
 */
public class Task6 {
  public static void main(String[] args) {
    System.out.println(factorial(1000));
  }

  private static BigInteger factorial(long n) {
    if (n == 1 || n == 0) {
      return BigInteger.ONE;
    } else {
      return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }
  }
}

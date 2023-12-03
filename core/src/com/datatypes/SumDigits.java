package com.datatypes;

import java.util.Scanner;
// from dmdev

/**
 * Написать программу, вычисляющую сумму цифр введённого пользователем целого числа.
 */
public class SumDigits {
  public static void main(String[] args) {
    System.out.print("Input an integer num: ");
    int sum = getSumDigits(new Scanner(System.in).nextInt());
    System.out.println("Sum of the digits is " + sum);
  }

  private static int getSumDigits(int value) {
    int res = 0;
    int currValue = value;
    while (currValue != 0) {
      res += currValue % 10;
      currValue /= 10;
    }
    return res;
  }
}
package com.horstmann.impatient.chap01;

import java.util.Scanner;

/**
 * Напишите программу, вводящую 3 целочисленных значения и выводящую самое большое из них,
 * используя только условную операцию. Сделайте то же самое с помощью метода Math.max()
 */
public class Task03 {
  public static void main(String[] args) {
    System.out.print("Введите значение 3 целых чисел через пробел: ");
    int firstNumber;
    int secondNumber;
    int thirdNumber;
    var scanner = new Scanner(System.in);

    firstNumber = scanner.nextInt();
    secondNumber = scanner.nextInt();
    thirdNumber = scanner.nextInt();

    System.out.println("Максимальное из 3 чисел: " + maxWithCondition(firstNumber, secondNumber, thirdNumber));
    System.out.println("Максимальное из 3 чисел: " + maxWithMathMax(firstNumber, secondNumber, thirdNumber));
  }

  private static int maxWithCondition(int firstNumber, int secondNumber, int thirdNumber) {
    int max = firstNumber > secondNumber ? firstNumber : secondNumber;
    return max > thirdNumber ? max : thirdNumber;
  }

  private static int maxWithMathMax(int firstNumber, int secondNumber, int thirdNumber) {
    return Math.max(Math.max(firstNumber, secondNumber), thirdNumber);
  }
}

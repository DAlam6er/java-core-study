package com.basics;

import java.util.Scanner;
// from dmdev

/**
 * Написать программу, отображающую статистику по осадкам за N дней.
 * N вводится пользователем.
 * Пользователь также должен ввести N целых чисел, обозначающих величину осадков в день.
 * Программа должна выводить:
 * a. Количество дней
 * b. Сумму осадков за этот период
 * c. Среднее количество осадков за этот период
 * d. Максимальное количество дневных осадков за этот период
 * Не использовать массивы!
 */
public class Statistics {
  public static void main(String[] args) {
    System.out.print("Input N days: ");
    Scanner scanner = new Scanner(System.in);
    int days = Integer.parseInt(scanner.nextLine());

    printStatistics(days);
  }

  private static void printStatistics(int days) {
    int sum = 0;
    double avg;
    int max = 0;
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < days; i++) {
      System.out.printf("Input precipitation data for day %d: ", i + 1);
      int ni = Integer.parseInt(scanner.nextLine());
      if (max < ni) max = ni;
      sum += ni;
    }
    avg = (double) sum / days;
    System.out.printf(
        "days: %d; total precipitation: %d; " +
        "average precipitation: %.2f; max precipitation: %d",
        days, sum, avg, max);
  }
}

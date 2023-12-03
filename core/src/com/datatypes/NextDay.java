package com.datatypes;

import java.util.Scanner;
// from dmdev

/**
 * Имеются три числа - день, месяц и год, вводимые пользователем с консоли.
 * Вывести дату следующего дня в формате "День.Месяц.Год".
 * Учесть переход на следующий месяц, а также следующий год.
 * Форматирование строки "День.Месяц.Год" вынести в отдельную функцию.
 */
public class NextDay {
  public static void main(String[] args) {
    int[] values = getInput();
    System.out.println("The next day is: " + getNextDay(values));
  }

  private static int[] getInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input day, month, year: ");
    int[] data = new int[3];
    int i = 0;
    while ((i < data.length) && scanner.hasNextInt()) {
      data[i++] = scanner.nextInt();
    }

    if (!isDateValid(data)) throw new RuntimeException("Invalid input");
    return data;
  }

  private static boolean isDateValid(int[] data) {
    int date = data[0];
    int month = data[1];
    int year = data[2];

    if (date <= 0 || date > 31 ||
        month <= 0 || month > 12 || year <= 0) {
      return false;
    }
    return date <= getDaysInMonths(year)[month - 1];
  }

  private static int[] getDaysInMonths(int year) {
    int daysInFebruary = 28;
    if (isLeapYear(year)) {
      daysInFebruary = 29;
    }
    return new int[]
        {31, daysInFebruary, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  }

  private static String getNextDay(int[] values) {
    int date = values[0];
    int month = values[1];
    int year = values[2];

    StringBuilder nextDay = new StringBuilder();
    if (date < getDaysInMonths(year)[month - 1]) {
      nextDay.append(String.format("%02d.", date + 1));
      nextDay.append(String.format("%02d.", month));
      nextDay.append(year);
    } else {
      nextDay.append("01.");
      if (month < 12) {
        nextDay.append(String.format("%02d.", month + 1));
        nextDay.append(year);
      } else {
        nextDay.append("01.");
        nextDay.append(year + 1);
      }
    }
    return nextDay.toString();
  }

  private static boolean isLeapYear(int year) {
    return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
  }
}

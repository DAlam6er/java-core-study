package com.horstmann.impatient.chap01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Напишите программу, вводящую двумерный массив целочисленных значений
 * и определяющую, содержится ли в нем магический квадрат (т.е. одинаковая
 * сумма значений во всех строках, столбцах и диагоналях).
 * Принимая строки вводимых данных, разбивайте их на отдельные целочисленные значения,
 * прекратив этот процесс, когда пользователь введет пустую строку.
 * Например, на следующие вводимые данные
 * 16  3  2 13
 * 5  10 11  8
 * 9   6  7 12
 * 4  15 14  1
 * программа должна ответить утвердительно
 */
public class Task14 {
  public static void main(String[] args) {
    System.out.println("Введите двумерный массив, разделяя числа пробелами. Для окончания ввода введите пустую строку.");
    int[][] twoDimArray = getFilledArray();
    if (isMagic(twoDimArray)) {
      System.out.println("Двумерный массив содержит магический квадрат");
    } else {
      System.out.println("Двумерный массив НЕ содержит магический квадрат");
    }
  }

  private static boolean isMagic(int[][] arrayOfRows) {
    long baseLineSum = getLineSum(arrayOfRows, 0);
    int baseLineSize = arrayOfRows[0].length;

    for (int i = 1; i < arrayOfRows.length; i++) {
      if (arrayOfRows[i].length != baseLineSize) {
        return false;
      }
      long currentLineSum = getLineSum(arrayOfRows, i);
      if (currentLineSum != baseLineSum) {
        return false;
      }
    }

    long baseColumnSum = getColumnSum(arrayOfRows, 0);

    for (int i = 1; i < arrayOfRows.length; i++) {
      long currentColumnSum = getColumnSum(arrayOfRows, i);
      if (currentColumnSum != baseColumnSum) {
        return false;
      }
    }

    return getMainDiagonalSum(arrayOfRows) == getAntiDiagonalSum(arrayOfRows);
  }

  private static long getMainDiagonalSum(int[][] twoDimArray) {
    long result = 0;
    for (int i = 0, j = 0, k = 0; k < twoDimArray.length; k++) {
      result = result + twoDimArray[i++][j++];
    }
    return result;
  }

  private static long getAntiDiagonalSum(int[][] twoDimArray) {
    long result = 0;
    for (int i = 0, j = twoDimArray[0].length - 1, k = 0; k < twoDimArray.length; k++) {
      result = result + twoDimArray[i++][j--];
    }
    return result;
  }

  private static long getColumnSum(int[][] arrayOfRows, int columnNumber) {
    long result = 0;
    for (int[] ints : arrayOfRows) {
      result = result + ints[columnNumber];
    }
    return result;
  }

  private static long getLineSum(int[][] twoDimArray, int lineNumber) {
    long result = 0;
    for (int j = 0; j < twoDimArray[lineNumber].length; j++) {
      result = result + twoDimArray[lineNumber][j];
    }
    return result;
  }

  private static int[][] getFilledArray() {
    Scanner scanner = new Scanner(System.in);
    List<String> input = new ArrayList<>();
    for (; ; ) {
      String line = scanner.nextLine();
      if (line.trim().isEmpty()) {
        break;
      }
      input.add(line);
    }
    int[][] result = new int[input.size()][];
    for (int i = 0; i < input.size(); i++) {
      String[] numbers = input.get(i).split(" ");
      result[i] = new int[numbers.length];
      for (int j = 0; j < numbers.length; j++) {
        result[i][j] = Integer.parseInt(numbers[j]);
      }
    }
    return result;
  }
}

package com.basics;

import java.util.Scanner;
// from dmdev

/**
 * Написать программу, вычисляющую корни квадратного уравнения вида
 * ax ² + bx + c = 0, где a, b и c - вводимые пользователем из консоли данные.
 * Учитывать только реальные корни (в случае отрицательного дискриминанта
 * выводить сообщение пользователю).
 */
public class SquareRoots {
  public static void main(String[] args) {
    double[] coeffs = getCoeffs();
    System.out.println("roots: " + getRoots(coeffs));
  }

  public static double[] getCoeffs() {
    double[] data = new double[3];
    Scanner scanner = new Scanner(System.in);
    int i = 0;
    while ((i < data.length) && scanner.hasNextInt()) {
      data[i++] = scanner.nextInt();
    }
    return data;
  }

  public static String getRoots(double[] coeffs) {
    double discr = getDiscriminant(coeffs);
    if (discr < 0) return "No real roots!";
    if (discr == 0) {
      return Double.toString(-coeffs[1] / (2 * coeffs[0]));
    } else {
      double root1 = ((-coeffs[1] - Math.sqrt(discr)) / (2 * coeffs[0]));
      double root2 = ((-coeffs[1] + Math.sqrt(discr)) / (2 * coeffs[0]));
      return String.format("(%.2f; %.2f)", root1, root2);
    }
  }

  private static double getDiscriminant(double[] coeffs) {
    return coeffs[1] * coeffs[1] - 4 * coeffs[0] * coeffs[2];
  }
}

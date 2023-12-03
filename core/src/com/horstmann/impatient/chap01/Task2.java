package com.horstmann.impatient.chap01;

import java.util.Scanner;

/**
 * Напишите программу, вводящую целочисленное (как положительное, так и отрицательное)
 * значение угла и нормализующую его в пределах от 0 до 359 градусов.
 * Попробуйте сделать это сначала с помощью операции % а затем методом floorMod()
 */
public class Task2 {
  private static final int BASE = 360;

  public static void main(String[] args) {
    System.out.print("Введите значение угла: ");
    var stringAngle = new Scanner(System.in).nextLine();
    if (Task1.isNumeric(stringAngle)) {
      var angle = Integer.parseInt(stringAngle);
      //System.out.println("Нормализованное значение угла: " + normalizeWithPercentOperation(angle));
      System.out.println("Нормализованное значение угла: " + normalizeWithFloorMod(angle));
    }
  }

  private static int normalizeWithFloorMod(Integer angle) {
    return Math.floorMod(angle, BASE);
  }

  private static int normalizeWithPercentOperation(Integer angle) {
    var value = angle >= 0 ? angle : BASE + angle;
    return value % BASE;
  }
}

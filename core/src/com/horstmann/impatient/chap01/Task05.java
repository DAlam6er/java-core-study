package com.horstmann.impatient.chap01;

/**
 * Что произойдёт, если привести числовое значение типа double к значению типа int,
 * которое больше самого большого значения типа int
 */
public class Task05 {
  public static void main(String[] args) {
    double maxInt = Integer.MAX_VALUE;
    System.out.println("Максимальное числовое значение int: " + maxInt);
    var increasedValue = (int) (maxInt + 100.0);
    System.out.println(increasedValue == Integer.MAX_VALUE);
  }
}

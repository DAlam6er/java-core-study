package com.horstmann.impatient.chap01;

/**
 * Напишите программу, выводящую наименьшее и наибольшее положительное
 * значения типа double. Подсказка: воспользуйтесь методом Math.nextUp()
 * из прикладного программного интерфейса Java API
 */
public class Task4 {
  public static void main(String[] args) {
    System.out.println("Наибольшее положительное значение типа integer: " + Integer.MAX_VALUE);
    System.out.println("Наименьшее отрицательное значение типа integer: " + Integer.MIN_VALUE);
    System.out.println("Наибольшее положительное значение типа double: " + Double.MAX_VALUE);
    System.out.println("Наименьшее положительное значение типа double: " + Double.MIN_VALUE);
    System.out.println("Наименьшее отрицательное значение типа double: " + (0 - Double.MAX_VALUE));
  }
}

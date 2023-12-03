package com.horstmann.impatient.chap02;

import org.omg.CORBA.IntHolder;

/**
 * Почему в Java нельзя реализовать метод, меняющий местами содержимое двух переменных типа int?
 * Вместо этого напишите метод, меняющий местами содержимое двух объектов типа IntHolder.
 * Можно ли поменять местами содержимое двух объектов типа Integer?
 */
public class Task4 {
  public static void main(String[] args) {
    int a = 13;
    int b = 14;
    System.out.println("Содержимое переменных перед вызовом метода:");
    System.out.printf("a = %d, b = %d\n", a, b);
    swap(a, b);
    System.out.println("Содержимое переменных после вызова метода:");
    System.out.printf("a = %d, b = %d\n", a, b); // содержимое переменных не изменилось!

    IntHolder first = new IntHolder(13);
    IntHolder second = new IntHolder(14);
    System.out.println("Содержимое объектов перед вызовом метода:");
    System.out.printf("first = %d, second = %d\n", first.value, second.value);
    swap(first, second);
    System.out.println("Содержимое объектов после вызова метода:");
    System.out.printf("first = %d, second = %d\n", first.value, second.value);
  }

  private static void swap(IntHolder one, IntHolder two) {
    int tmp = one.value;
    one.value = two.value;
    two.value = tmp;
  }

  private static void swap(int x, int y) {
    x ^= y; //x = x ^ y;
    y ^= x; //y = x ^ y;
    x ^= y; //x = x ^ y;
    System.out.printf("x = %d\ny = %d\n", x, y);
  }
}

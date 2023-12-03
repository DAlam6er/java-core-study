package com.horstmann.impatient.chap01;

import java.util.Random;

/**
 * Напишите программу, составляющую произвольную символьную строку из букв и цифр,
 * генерируя произвольное значение типа long и выводя его по основанию 36
 */
public class Task10 {
  public static void main(String[] args) {
    var random = new Random().nextLong();
    System.out.println(Long.toString(random, 36));
  }
}

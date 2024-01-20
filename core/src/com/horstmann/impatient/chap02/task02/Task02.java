package com.horstmann.impatient.chap02.task02;

import java.util.Random;
import java.util.Scanner;

/**
 * Проанализируйте метод nextInt() из класса Scanner. Является ли он методом доступа
 * или модифицирующим методом и почему? А что можно сказать о методе nextInt() из класса Random?
 */
public class Task02 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int token = scanner.nextInt(); // модифицирующий метод, т.к. меняет значения полей radix, hasNextPattern, typeCache, position класса Scanner

    Random random = new Random();
    int randomInt = random.nextInt(); // метод доступа, т.к. не меняет объект Random
  }
}

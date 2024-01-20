package com.streamapi.warburton.chap03;

/**
 * Подсчитайте количество строчных букв в строке
 */
public class Task06 {
  public static void main(String[] args) {
    long count = countLowerLetters("Hello, world!");
    System.out.println("Число строчных букв в выражении: " + count);
  }

  public static long countLowerLetters(String str) {
    return str.chars().filter(Character::isLowerCase).count();
  }
}

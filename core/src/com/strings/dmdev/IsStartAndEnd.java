package com.strings.dmdev;

/**
 * 2. Написать функцию, принимающую 2 параметра: строку и слово -
 * и возвращающую true, если строка начинается и заканчивается этим словом
 */
public class IsStartAndEnd {
  public static void main(String[] args) {
    String value = "123 dffadsas fasdf 123";
    String word = "123";
    System.out.println(isStartAndEnd(value, word));
  }

  public static boolean isStartAndEnd(String target, String word) {
    return target.startsWith(word) && target.endsWith(word);
  }
}

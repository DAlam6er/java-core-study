package com.exceptions.dmdev;

import java.util.Random;

/**
 * 7. Написать метод, который в 50% случаев бросает исключение.
 * Вызвать этот метод в конструкции try-catch-finally.
 * Протестировать работу блока finally.
 */
public class Task7 {
  public static void main(String[] args) {
    try {
      unsafe50();
    } catch (Exception e) {
      System.err.println("catched");
      e.printStackTrace();
    } finally {
      System.out.println("Final block");
    }
  }

  public static void unsafe50() {
    if (new Random().nextBoolean()) {
      throw new RuntimeException();
    }
  }
}

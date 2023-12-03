package com.exceptions.dmdev;

/**
 * 3. Создать собственный класс-исключение - наследник класса Exception.
 * Создать метод, выбрасывающий это исключение.
 * Вызвать этот метод и отловить исключение.
 * Вывести stack trace в консоль.
 */
public class Task3 {
  public static void main(String[] args) {
    try {
      unsafe();
    } catch (DmdevException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCause());
      e.printStackTrace();
    }
  }

  public static void unsafe() throws DmdevException {
    // Оборачиваем одно исключение вокруг другого
    throw new DmdevException(new RuntimeException("dmdev exception"));
  }
}

class DmdevException extends Exception {
  public DmdevException(String message) {
    super(message);
  }

  public DmdevException(Throwable cause) {
    super(cause);
  }
}
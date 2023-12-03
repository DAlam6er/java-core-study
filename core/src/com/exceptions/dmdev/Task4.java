package com.exceptions.dmdev;

/**
 * 4. Повторить предыдущее упражнение, но наследуя свой класс от класса
 * RuntimeException.
 * Добавить в конструктор своего класса возможность указания
 * сообщения.
 */
public class Task4 {
  public static void main(String[] args) {
    try {
      unsafe();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void unsafe() {
    throw new DmdevRuntimeException(new RuntimeException("runtime exception"));
  }
}

class DmdevRuntimeException extends RuntimeException {
  public DmdevRuntimeException(String message) {
    super(message);
  }

  public DmdevRuntimeException(Throwable cause) {
    super(cause);
  }
}

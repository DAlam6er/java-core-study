package com.exceptions.dmdev;

/**
 * 1. Объявите переменную со значением null. Вызовите метод у этой
 * переменной. Отловите возникшее исключение.
 * В РЕАЛЬНОЙ ЖИЗНИ ТАК ДЕЛАТЬ НЕ СЛЕДУЕТ - ЭТО НЕОТЛАВЛИМАЕМОЕ ИСКЛЮЧЕНИЕ!
 */
public class Task1 {
  public static void main(String[] args) {
    Object value = null;
    try {
      value.getClass();
    } catch (NullPointerException e) {
      System.err.println("catch");
      e.printStackTrace();
    }
  }
}

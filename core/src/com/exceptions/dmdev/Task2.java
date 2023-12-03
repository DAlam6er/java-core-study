package com.exceptions.dmdev;

/**
 * 2. Написать код, который создаст, а затем отловит
 * ArrayIndexOutOfBoundsException.
 * В РЕАЛЬНОЙ ЖИЗНИ ТАК ДЕЛАТЬ НЕ СЛЕДУЕТ - ЭТО НЕОТЛАВЛИМАЕМОЕ ИСКЛЮЧЕНИЕ!
 */
public class Task2 {
  public static void main(String[] args) {
    int[] values = {1, 4, 6, 7, 8};
    try {
      for (int i = 0; i <= values.length; i++) {
        System.out.println(values[i]);
      }
    } catch (IndexOutOfBoundsException ex) {
      System.err.println("catch");
      ex.printStackTrace();
    }
  }
}

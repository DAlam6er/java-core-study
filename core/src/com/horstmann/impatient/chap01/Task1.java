package com.horstmann.impatient.chap01;

import java.util.Scanner;

/**
 * Напишите программу, вводящую целочисленное значение и выводящую его в двоичной,
 * восьмиричной и шестнадцатиричной форме.
 * Организуйте вывод обратного значения в виде шестнадцатеричного числа с плавающей точкой
 */
public class Task1 {
  public static void main(String[] args) {
    var in = new Scanner(System.in);
    System.out.print("Введите целочисленное значение: ");
    var input = in.nextLine();
    if (isNumeric(input)) {
      var decimal = Integer.parseInt(input);
      System.out.printf("Двочная форма числа: %s\n", Integer.toString(decimal, 2));
      System.out.printf("Восьмиричная форма числа: %s\n", Integer.toString(decimal, 8));
      System.out.printf("Шестнадцатиричная форма числа: %s\n", Integer.toString(decimal, 16).toUpperCase());
      System.out.printf("Обратное значение: %a", 1 / (double) decimal);
    }
  }

  public static boolean isNumeric(String value) {
    if (value.isEmpty()) {
      return false;
    }

    var charArray = value.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      var character = charArray[i];
      if ((i != 0 && character == '-')
          || (!Character.isDigit(character) && character != '-')
          || (charArray.length == 1 && character == '-')) {
        return false;
      }
    }

    return true;
  }
}

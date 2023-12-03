package com.horstmann.impatient.chap01;

import java.util.Scanner;

/**
 * Напишите программу, вводящую текстовую строку и выводящую все символы,
 * не представленные в коде ASCII, вместе с их значениями в Юникоде
 */
public class Task11 {
  public static void main(String[] args) {
    System.out.print("Введите символьную строку: ");
    var scanner = new Scanner(System.in).nextLine();
    var charArray = scanner.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      if (charArray[i] > 127) {
        System.out.printf("%c - \\u%04x\n", charArray[i], (short) charArray[i]);
      }
    }
  }
}

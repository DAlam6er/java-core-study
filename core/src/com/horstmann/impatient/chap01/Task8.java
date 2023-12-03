package com.horstmann.impatient.chap01;

import java.util.Scanner;

/**
 * Напишите программу, вводящую символьную строку и выводящую все ее непустые подстроки
 */
public class Task8 {
  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    System.out.print("Введите символьную строку: ");
    var inputString = scanner.nextLine();

    printAllNonEmptyStrings(inputString);
  }

  private static void printAllNonEmptyStrings(String inputString) {
    var trimmedString = inputString.trim();
    if (!trimmedString.isEmpty()) {
      System.out.println("Непустые подстроки введенной строки:");
      for (int i = 0; i < trimmedString.length() - 1; i++) {
        var substring = String.join("", trimmedString.substring(0, i), trimmedString.substring(i, i + 1));
        System.out.println(substring);
      }
    }
  }
}

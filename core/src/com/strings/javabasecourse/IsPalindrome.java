package com.strings.javabasecourse;

/**
 * Проверить, является ли введённая строка палиндромом,
 * т.е. читается одинаково в обоих направлениях
 */
public class IsPalindrome {
  public static void main(String[] args) {
    System.out.println(isPalindrome("Madam, I'm Adam!"));
  }

  public static boolean isPalindrome(String text) {
    String formatted =
        text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    return
        formatted.equals(new StringBuilder(formatted).reverse().toString());
  }
}

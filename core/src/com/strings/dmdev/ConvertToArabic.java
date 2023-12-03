package com.strings.dmdev;

/**
 * Написать программу, преобразующую строку, содержащую число в
 * римском формате, в число в арабском формате.
 * Границы чисел: от 1 до 3999. Предусмотреть случай, когда меньший символ
 * идёт перед большим:
 * Например CM == 900.
 * Соответствие:
 * M 1000
 * D 500
 * C 100
 * L 50
 * X 10
 * V 5
 * I 1
 */
public class ConvertToArabic {
  public static void main(String[] args) {
    String value = "CM";
    int result = convertToArabic(value);
    System.out.println(result);
  }

  private static int convertToArabic(String romanNumber) {
    int prevArabic = getArabic(romanNumber.charAt(romanNumber.length() - 1));
    int result = prevArabic;
    for (int i = romanNumber.length() - 2; i >= 0; i--) {
      int currentArabic = getArabic(romanNumber.charAt(i));
      result += currentArabic < prevArabic ? -currentArabic : currentArabic;
      prevArabic = currentArabic;
    }
    return result;
  }

  /**
   * @param romanChar number in a roman format
   * @return number in an arabic format
   */
  public static int getArabic(char romanChar) {
    return switch (romanChar) {
      case 'M' -> 1000;
      case 'D' -> 500;
      case 'C' -> 100;
      case 'L' -> 50;
      case 'X' -> 10;
      case 'V' -> 5;
      case 'I' -> 1;
      default -> 0;
    };
  }
}

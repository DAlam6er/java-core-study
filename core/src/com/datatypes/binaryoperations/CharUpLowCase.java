package com.datatypes.binaryoperations;

// Демонстрация преобразования ASCII-символов к верхнему и нижнему регистру
public class CharUpLowCase {
  public static void main(String[] args) {
    char ch;

    for (int i = 0; i < 26; i++) {
      ch = (char) ('a' + i);
      System.out.print(ch + "->");
      ch = upCase(ch);
      System.out.print(ch + "; ");
    }
    System.out.println();
    for (int i = 0; i < 26; i++) {
      ch = (char) ('A' + i);
      System.out.print(ch + "->");
      ch = lowCase(ch);
      System.out.print(ch + "; ");
    }
  }

  public static char upCase(char ch) {
    // эта команда отключает 6-й бит
    // 1111 1111 1101 1111
    return (char) ((int) ch & 0xFFDF);
  }

  public static char lowCase(char ch) {
    // эта команда включает 6-й бит
    // 0010 0000
    return (char) ((int) ch | 0x20);
  }
}

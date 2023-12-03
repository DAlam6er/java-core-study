package com.strings.javarush;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    Написать программу, которая вводит с клавиатуры строку текста.
    Программа должна вывести на экран две строки:

    Первая строка содержит только гласные буквы из введённой строки.
    Вторая — только согласные буквы и знаки препинания из введённой строки.

    Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

    Ввод: Мама мыла раму.
    Вывод: М м м л р м .
 */
public class Vowels {
  public static char[] vowels =
      new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    String str = br.readLine();
    StringBuilder strbVowel = new StringBuilder();
    StringBuilder strbOther = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (isVowel(ch)) {
        strbVowel.append(ch).append(" ");
      } else {
        if (ch != 32) {
          strbOther.append(ch).append(" ");
        }
      }
    }
    System.out.println(strbVowel);
    System.out.println(strbOther);
  }

  // метод проверяет, гласная ли буква
  public static boolean isVowel(char character) {
    // приводим символ в нижний регистр - от заглавных к строчным буквам
    character = Character.toLowerCase(character);
    // ищем среди массива гласных
    for (char vowel : vowels) {
      if (character == vowel) {
        return true;
      }
    }
    return false;
  }
}

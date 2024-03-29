package com.regexpressions.dmdev.tasks;

import java.util.regex.Pattern;

/**
 * 1. Написать программу, проверяющую, является ли введённая
 * строка адресом почтового ящика.
 * В названии почтового ящика разрешить использование только
 * букв, цифр и нижних подчёркиваний, при этом оно должно
 * начинаться с буквы.
 * Возможные домены верхнего уровня: .org .com
 */
public class Task1 {
  public static void main(String[] args) {
    String regex = "[a-zA-Z]\\w*@\\w{3,}\\.(org|com)";
    //String input = "dmdev@gmail.com";
    //String input = "1dmdev@gmail.com";
    String input = "dmdev@gmail.ru";
    System.out.println(Pattern.matches(regex, input));
  }
}

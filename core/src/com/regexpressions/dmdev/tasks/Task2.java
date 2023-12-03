package com.regexpressions.dmdev.tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2. Написать программу, выполняющую поиск в строке
 * шестнадцатеричных чисел, записанных по правилам Java,
 * с помощью регулярных выражений и выводящую их на страницу.
 */
public class Task2 {
  public static void main(String[] args) {
    //int value = 0xF;
    String regex = "0[xX][0-9a-fA-F]+";
    String input = "asdfasd 0xFF asdfasdf 0x12 asdfasdf 0XAB afasdf 1x24F asdf 0TaC";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }
}

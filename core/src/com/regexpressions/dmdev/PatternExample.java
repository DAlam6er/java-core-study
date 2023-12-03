package com.regexpressions.dmdev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {
  public static void main(String[] args) {
    String phoneNumber = "+375(29) 898-12-13";
    String regex = "\\+375\\s?\\(\\d{2}\\)\\s?\\d{3}-\\d{2}-\\d{2}";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(phoneNumber);
    System.out.println(matcher.matches());

    // Упрощенный вариант метода matches()
    System.out.println(Pattern.matches(regex, phoneNumber));
  }
}

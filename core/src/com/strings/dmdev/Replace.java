package com.strings.dmdev;

/**
 * 1. Заменить все грустные смайлы :( в строке на весёлые :)
 */
public class Replace {
  public static void main(String[] args) {
    String value = "asdfadsgsgs :( adsfasdfasdf :( fasdfasdf :) sdfsdf :) dasfasdf :( asdfadf";
    String result = replace(value);
    System.out.println(result);
  }

  public static String replace(String value) {
    return value.replace(":(", ":)");
  }
}

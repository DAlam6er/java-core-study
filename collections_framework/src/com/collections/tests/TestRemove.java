package com.collections.tests;

import java.util.ArrayList;
import java.util.List;

public class TestRemove {
  public static void main(String[] args) {
    List<String> source = new ArrayList<>();
    source.add("один");
    source.add("два");
    source.add("три");

    List<String> copy = source;

    copy.remove("два");

    System.out.println("Содержимое исходного списка: " + source);
    System.out.println("Содержимое копии списка: " + copy);
  }
}

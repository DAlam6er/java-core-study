package com.collections.stepik.javabasecourse.examples;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReadDeletePrintDemo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Deque<Integer> deque = new ArrayDeque<>();
    byte pos = 0;
    while (scanner.hasNextInt()) {
      if (pos++ % 2 == 0) {
        scanner.nextInt();
        continue;
      }
      deque.addFirst(scanner.nextInt());
    }

    for (Integer element : deque) {
      System.out.printf("%d ", element);
    }
  }
}

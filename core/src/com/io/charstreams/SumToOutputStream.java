package com.io.charstreams;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SumToOutputStream {
  public static void main(String[] args) {
    double sum = 0;
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      try {
        sum += scanner.nextDouble();
      } catch (InputMismatchException e) {
        scanner.next();
      }
    }
    System.out.printf("%.6f", sum);
  }
}

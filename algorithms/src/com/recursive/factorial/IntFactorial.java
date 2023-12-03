package com.recursive.factorial;

// FROM grokking algorithms
public class IntFactorial {
  public static void main(String[] args) {
    System.out.println("5! = " + factor(5));
    System.out.println("4! = " + factor(4));
  }

  static long factor(int x) {
    if (x == 0) {
      return 1;
    } else {
      return factor(x - 1) * x;
    }
  }
}

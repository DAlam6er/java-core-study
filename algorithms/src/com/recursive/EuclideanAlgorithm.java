package com.recursive;

/**
 * Алгоритм для нахождения наибольшего общего делителя двух целых чисел
 */
public class EuclideanAlgorithm {
  public static void main(String[] args) {
    System.out.println(getGCD(12, 8));
  }

  public static int getGCD(int a, int b) {
    if (b == 0) return a;
    // b является большим из двух чисел (b, a%b)
    return getGCD(b, a % b);
  }
}

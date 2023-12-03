package com.recursive;

import java.math.BigInteger;

/**
 * Написать программу, вычисляющую возведение в степень числа
 */
public class Exponentiation {
  public static void main(String[] args) {
    System.out.println(power(13, 50));
    System.out.println(fastPower(13, 50));
  }

  // a^n = a * a^(n-1), n > 0
  public static BigInteger power(int a, int n) {
    if (n == 0) return BigInteger.ONE;
    return new BigInteger(String.valueOf(a)).multiply(power(a, n - 1));
  }

  // Быстрое возведение в степень: a^n = a^2 * a^(n/2), n - четное
  public static BigInteger fastPower(int a, int n) {
    if (n == 0) return BigInteger.ONE;
    if (n % 2 == 0) return fastPower(a * a, n / 2);
    return new BigInteger(String.valueOf(a)).multiply(fastPower(a, n - 1));
  }
}

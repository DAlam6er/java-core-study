package com.streamapi.javabasecourse.examples;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Factorial {
  public static BigInteger factorial(int n) {
    return IntStream.rangeClosed(1, n)
        .mapToObj(i -> BigInteger.valueOf(i))
        .reduce(BigInteger.ONE, BigInteger::multiply);
  }
}

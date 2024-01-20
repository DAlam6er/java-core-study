package com.streamapi.warburton.chap05;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Найдите эффективный способ вычисления последовательности чисел Фибоначчи,
 * в котором используется только метод computeIfAbsent интерфейса Map
 * Под эффективностью подразумевается, что ни одно число Фибоначчи не вычисляется дважды
 */
public class Fibonacci {
  private final Map<Integer, BigInteger> cache;

  public Fibonacci() {
    cache = new ConcurrentHashMap<>();
    cache.put(0, BigInteger.ZERO);
    cache.put(1, BigInteger.ONE);
  }

  public BigInteger fibonacci(int seqNumber) {
    return cache.computeIfAbsent(seqNumber, n -> fibonacci(n - 1).add(fibonacci(n - 2)));
  }
}

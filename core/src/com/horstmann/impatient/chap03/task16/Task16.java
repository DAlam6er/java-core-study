package com.horstmann.impatient.chap03.task16;

import java.util.Random;

/**
 * Реализуйте локальный класс RandomSequence как вложенный класс за пределами метода
 * randomInts()
 */
public class Task16 {
  public static IntSequence<Integer> randomInts(int low, int high) {
    return new RandomSequence(low, high);
  }

  private static class RandomSequence implements IntSequence<Integer> {
    private static final Random generator = new Random();
    private final int low;
    private final int high;

    public RandomSequence(int low, int high) {
      this.low = low;
      this.high = high;
    }

    @Override
    public Integer next() {
      return low + generator.nextInt(high - low + 1);
    }
  }
}

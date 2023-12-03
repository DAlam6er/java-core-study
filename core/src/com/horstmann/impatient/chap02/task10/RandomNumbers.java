package com.horstmann.impatient.chap02.task10;

import java.util.List;
import java.util.Random;

public class RandomNumbers {
  private static final Random generator = new Random();

  public static int nextInt(int low, int high) {
    return low + generator.nextInt(high - low + 1);
  }

  public static Integer randomElement(int[] array) {
    if (array.length == 0) {
      return 0;
    }
    return array[nextInt(0, array.length - 1)];
  }

  public static Integer randomElement(List<Integer> array) {
    if (array.isEmpty()) {
      return 0;
    }
    return array.get(nextInt(0, array.size() - 1));
  }
}

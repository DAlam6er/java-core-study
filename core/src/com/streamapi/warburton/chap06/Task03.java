package com.streamapi.warburton.chap06;

import java.util.stream.IntStream;

/**
 * В примере вычисляется сумма квадратов элементов списка.
 * Нужно улучшить её производительность, не жертвуя качеством.
 */
public class Task03 {
  public int slowSumOfSquares(IntStream range) {
    return range.parallel()
        .map(x -> x * x)
        .reduce(0, (acc, x) -> acc + x);
  }

  public int improvedSumOfSquares(IntStream range) {
    return range.parallel()
        .map(x -> x * x)
        .sum();
  }
}

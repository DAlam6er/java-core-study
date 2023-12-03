package com.horstmann.impatient.chap03.task06;

import java.math.BigInteger;

public class SquareSequence implements IntSequence<BigInteger> {
  private BigInteger increasedValue = BigInteger.ZERO;

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public BigInteger next() {
    increasedValue = increasedValue.add(BigInteger.ONE);
    return increasedValue.multiply(increasedValue);
  }
}

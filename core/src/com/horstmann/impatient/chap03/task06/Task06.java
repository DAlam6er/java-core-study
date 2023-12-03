package com.horstmann.impatient.chap03.task06;

import java.math.BigInteger;

/**
 * На самом деле класс SquareSequence не предоставляет бесконечную последовательность
 * квадратов целых чисел из-за возможного переполнения. Как же он тогда действует?
 * Устраните этот недостаток, определив интерфейс Sequence&lt;T> и класс SquareSequence,
 * реализующий интерфейс Sequence&lt;BigInteger>
 */
public class Task06 {
  public static void main(String[] args) {
    IntSequence<BigInteger> squareSequence = new SquareSequence();
    int i = 0;
    while (i <= 999_999) {
      BigInteger token = squareSequence.next();
      System.out.println("step: " + i++ + ", element: " + token);
    }
  }
}

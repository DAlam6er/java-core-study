package com.horstmann.impatient.chap03.task06;

public interface IntSequence<T> {
  boolean hasNext();

  T next();
}

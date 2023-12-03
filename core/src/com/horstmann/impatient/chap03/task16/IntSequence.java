package com.horstmann.impatient.chap03.task16;

public interface IntSequence<T> {
  default boolean hasNext() {
    return true;
  }

  T next();
}

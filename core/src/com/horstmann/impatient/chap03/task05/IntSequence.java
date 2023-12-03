package com.horstmann.impatient.chap03.task05;

public interface IntSequence {
  static IntSequence constant(int n) {
    return () -> n;
  }

  default boolean hasNext() {
    return true;
  }

  int next();
  /*static IntSequence constant(int n) {
    return new IntSequence() {
      @Override
      public int next() {
        return n;
      }
    };
  }*/
}

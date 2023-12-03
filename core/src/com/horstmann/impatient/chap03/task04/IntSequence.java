package com.horstmann.impatient.chap03.task04;

public interface IntSequence {
  static IntSequence of(int a) {
    return makeFinitSequence(a);
  }

  static IntSequence of(int a, int b) {
    return makeFinitSequence(a, b);
  }

  static IntSequence of(int a, int b, int c) {
    return makeFinitSequence(a, b, c);
  }

  static IntSequence of(int a, int b, int c, int d) {
    return makeFinitSequence(a, b, c, d);
  }

  static IntSequence of(int a, int b, int c, int d, int e) {
    return makeFinitSequence(a, b, c, d, e);
  }

  static IntSequence of(int a, int b, int c, int d, int e, int f) {
    return makeFinitSequence(a, b, c, d, e, f);
  }

  private static IntSequence makeFinitSequence(int... values) {
    return new IntSequence() {
      private int currentElement;

      @Override
      public boolean hasNext() {
        return values.length - 1 >= currentElement;
      }

      @Override
      public int next() {
        return values[currentElement++];
      }

      @Override
      public String toString() {
        StringBuilder sb = new StringBuilder();
        while (hasNext()) {
          sb.append(next());
          if (hasNext()) {
            sb.append(" ");
          }
        }
        return sb.toString();
      }
    };
  }

  default boolean hasNext() {
    return true;
  }

  int next();
}

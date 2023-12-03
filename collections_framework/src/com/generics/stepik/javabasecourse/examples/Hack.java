package com.generics.stepik.javabasecourse.examples;

import java.io.IOException;

// Превращение проверяемого исключения в непроверяемое
public class Hack {
  public static void main(String[] args) {
    throwAsUnchecked(new IOException());
  }

  private static void throwAsUnchecked(Exception e) {
    Hack.<RuntimeException>genericThrow(e);
  }

  private static <T extends Throwable> void genericThrow(Exception e)
      throws T {
    throw (T) e;
  }
}

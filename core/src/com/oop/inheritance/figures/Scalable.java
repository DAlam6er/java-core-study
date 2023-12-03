package com.oop.inheritance.figures;

public interface Scalable {

  int DEFAULT_FACTOR = 2;

  default void scale() {
    scale(DEFAULT_FACTOR);
  }

  void scale(double factor);
  //16:07
}

package com.oop.polymorphism.figures;

public class Circle extends Shape {
  private int r;

  public Circle(int x, int y, int r, String name) {
    super(x, y, name);
    this.r = r;
  }

  @Override
  public String toString() {
    return super.toString() + ", r=" + r;
  }

  @Override
  public double area() {
    return Math.PI * r * r;
  }
}

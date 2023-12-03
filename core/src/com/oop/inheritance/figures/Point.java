package com.oop.inheritance.figures;

public class Point extends Shape {

  public Point(int x, int y) {
    super(x, y);
  }

  @Override
  public double area() {
    return 0;
  }

  @Override
  public String toString() {
    return "Point{" +
           "x=" + getX() +
           ", y=" + getY() +
           '}';
  }

}

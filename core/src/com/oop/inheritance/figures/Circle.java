package com.oop.inheritance.figures;


public class Circle extends Ellipse implements Comparable<Circle> {

  public Circle(int x, int y) {
    super(x, y);
  }

  public Circle(int x, int y, double r) {
    super(x, y, r, r);
  }

  @Override
  public String toString() {
    return "Circle{" +
           "r=" + getR() +
           ", x=" + getX() +
           ", y=" + getY() +
           "}";
  }

  public double getR() {
    return getR1();
  }

  public void setR(double r) {
    setR1(r);
    setR2(r);
  }

  @Override
  public int compareTo(Circle o) {
    return (int) (getR() - o.getR());
  }
}

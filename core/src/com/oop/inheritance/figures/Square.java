package com.oop.inheritance.figures;

public class Square extends Rectangle {

  public Square(double side) {
    super(0, 0, side, side);
    setSide(side);
  }

  public Square(int x, int y, double side) {
    super(x, y, side, side);
  }

  @Override
  public String toString() {
    return "Square{" +
           "side=" + getSide() +
           ", x=" + getX() +
           ", y=" + getY() +
           '}';
  }

  public double getSide() {
    return getW();
  }

  public void setSide(double side) {
    setW(side);
    setH(side);
  }

}

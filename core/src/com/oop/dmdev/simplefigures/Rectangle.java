package com.oop.dmdev.simplefigures;

public class Rectangle {
  private final Point leftUpperCorner;
  private final Point rightLowerCorner;

  public Rectangle(Point leftUpperCorner, Point rightLowerCorner) {
    this.leftUpperCorner = leftUpperCorner;
    this.rightLowerCorner = rightLowerCorner;
  }

  public double getDiagonal() {
    return leftUpperCorner.distance(rightLowerCorner);
  }

  public int getArea() {
    return (rightLowerCorner.getX() - leftUpperCorner.getX()) *
           (leftUpperCorner.getY() - rightLowerCorner.getY());
  }
}

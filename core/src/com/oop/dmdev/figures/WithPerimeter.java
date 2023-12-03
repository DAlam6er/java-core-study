package com.oop.dmdev.figures;

public interface WithPerimeter {
  default double getSide(Point point1, Point point2) {
    return point1.distance(point2);
  }

  default double getSemiPerimeter() {
    return getPerimeter() / 2.0;
  }

  double getPerimeter();
}

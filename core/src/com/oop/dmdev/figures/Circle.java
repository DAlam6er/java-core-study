package com.oop.dmdev.figures;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Circle extends Figure implements WithPerimeter {
  private final Point point;
  private final double radius;

  public Circle(Point point, double radius) {
    this.point = point;
    this.radius = radius;
  }

  /**
   * Предпочитать использовать статический импорт для общеизвестных функций.
   * В частности, лучше использовать такой
   * статический импорт для всех математический функций из утилитного класса Math.
   *
   * @return площадь круга
   */
  @Override
  public double getArea() {
    return PI * pow(radius, 2.0);
  }

  @Override
  public double getPerimeter() {
    return 2 * PI * radius;
  }

  @Override
  public String toString() {
    return "Circle{" +
           "point=" + point +
           ", radius=" + radius +
           "}";
  }

  public Point getPoint() {
    return point;
  }

  public double getRadius() {
    return radius;
  }
}

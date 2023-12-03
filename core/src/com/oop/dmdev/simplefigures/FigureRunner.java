package com.oop.dmdev.simplefigures;

import java.util.Locale;

public class FigureRunner {
  public static void main(String[] args) {
    Point point1 = new Point(2, 10);
    Point point2 = new Point(12, 4);

    System.out.printf(Locale.ROOT, "%.2f\n", point1.distance(point2));
    System.out.printf(Locale.ROOT, "%.2f\n", point2.distance(point1));

    Rectangle rectangle = new Rectangle(point1, point2);
    System.out.println(rectangle.getArea());
    System.out.printf(Locale.ROOT, "%.2f\n", rectangle.getDiagonal());
  }
}

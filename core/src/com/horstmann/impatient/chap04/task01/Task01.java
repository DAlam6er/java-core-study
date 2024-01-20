package com.horstmann.impatient.chap04.task01;

/**
 * Определите класс Point с конструктором Point(double x, double y)
 * и методами доступа getX() getY()
 * Определите также подкласс LabeledPoint с конструктором LabeledPoint(String label, double x, double y)
 * и методом доступа getLabel()
 */
public class Task01 {
  public static void main(String[] args) {
    Point point = new Point(1.5, 2.5);
    Point labeledPoint = new LabeledPoint(0.0, 0.0, "origin");
  }
}

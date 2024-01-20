package com.horstmann.impatient.chap04.task02;

/**
 * Определите методы toString(), equals() и hashCode() для классов из предыдущего упражнения
 */
public class Task02 {
  public static void main(String[] args) {
    Point point = new Point(1.5, 2.5);
    Point labeledPoint = new LabeledPoint(0.0, 0.0, "origin");
    System.out.println("point: " + point);
    System.out.println("labeledPoint: " + labeledPoint);
  }
}

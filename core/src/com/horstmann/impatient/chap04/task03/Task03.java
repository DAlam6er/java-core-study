package com.horstmann.impatient.chap04.task03;

import com.horstmann.impatient.chap04.task03.point.Point;

/**
 * Объявите как protected переменные экземпляра x и y из класса Point в упражнении 1
 * Продемонстрируйте, что эти переменные доступны классу LabeledPoint только в его экземплярах
 */
public class Task03 {
  public static void main(String[] args) {
    Point point = new Point(1.5, 2.5);
    Point labeledPoint = new LabeledPoint(0.0, 0.0, "origin");
    // 'x' has protected access in 'com.horstmann.impatient.chap04.task03.point.Point'
    //System.out.println("labeledPoint x: " + labeledPoint.x);
    System.out.println("labeledPoint x: " + labeledPoint.getX());
    //System.out.println("labeledPoint y: " + labeledPoint.y);
    System.out.println("labeledPoint y: " + labeledPoint.getY());
  }
}

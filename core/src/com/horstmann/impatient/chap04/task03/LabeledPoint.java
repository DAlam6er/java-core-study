package com.horstmann.impatient.chap04.task03;

import com.horstmann.impatient.chap04.task03.point.Point;

public class LabeledPoint extends Point {
  private final String label;

  public LabeledPoint(double x, double y, String label) {
    super(x, y);
    this.label = label;
  }

  public void printX() {
    System.out.println("x = " + x);
  }

  public void printY() {
    System.out.println("y = " + y);
  }

  public String getLabel() {
    return label;
  }
}

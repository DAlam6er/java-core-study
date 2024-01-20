package com.horstmann.impatient.chap04.task01;

public class LabeledPoint extends Point {
  private final String label;

  public LabeledPoint(double x, double y, String label) {
    super(x, y);
    this.label = label;
  }

  public String getLabel() {
    return label;
  }
}

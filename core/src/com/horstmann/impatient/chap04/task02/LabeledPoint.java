package com.horstmann.impatient.chap04.task02;

public class LabeledPoint extends Point {
  private final String label;

  public LabeledPoint(double x, double y, String label) {
    super(x, y);
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  public String toString() {
    return super.toString() + "[label=" + label + "]";
  }
}

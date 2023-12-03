package com.horstmann.impatient.chap03.task01;

public class Employee implements Measurable {
  private final double salary;

  public Employee(double salary) {
    this.salary = salary;
  }

  @Override
  public double getMeasure() {
    return salary;
  }
}

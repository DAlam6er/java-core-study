package com.horstmann.impatient.chap03.task02;

public class Employee implements Measurable {
  private final double salary;
  private String name;

  public Employee(double salary) {
    this.salary = salary;
  }

  public Employee(String name, double salary) {
    this(salary);
    this.name = name;
  }

  @Override
  public double getMeasure() {
    return salary;
  }

  public String getName() {
    return name;
  }
}

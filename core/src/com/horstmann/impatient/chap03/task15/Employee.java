package com.horstmann.impatient.chap03.task15;

public class Employee {
  private String name;
  private int salary;

  public Employee(String name, int salary) {
    this.salary = salary;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + '}';
  }
}

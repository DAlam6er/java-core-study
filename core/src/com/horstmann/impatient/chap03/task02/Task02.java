package com.horstmann.impatient.chap03.task02;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Продолжите предыдущее упражнение, предоставив метод Measurable largest(Measurable[] objects)
 * Воспользуйтесь им, чтобы выяснить имя работника с самой высокой зарплатой.
 * Зачем требуется приведение типов? - Для вызова метода, характерного для объекта класса Employee
 */
public class Task02 {
  public static void main(String[] args) {
    Measurable[] employees = new Measurable[6];
    employees[0] = new Employee("Vasilii", 300.0);
    employees[1] = new Employee("Nickolai", 100.0);
    employees[2] = new Employee("Sveta", 200.0);
    employees[3] = new Employee("Valentin", 350.0);
    employees[4] = new Employee("Olga", 500.0);
    employees[5] = new Employee("Petr", 800.0);

    Measurable largest = new Task02().largest(employees);
    if (largest instanceof Employee) {
      System.out.println("Имя работника с самой высокой зарплатой: " + ((Employee) largest).getName());
    }
  }

  public Measurable largest(Measurable[] objects) {
    return Arrays.stream(objects).max(Comparator.comparing(Measurable::getMeasure)).orElse(null);
  }
}

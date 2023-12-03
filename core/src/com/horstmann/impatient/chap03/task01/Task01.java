package com.horstmann.impatient.chap03.task01;

import java.util.Arrays;

/**
 * Предоставьте интерфейс Measurable с методом double getMeasure(), измеряющем объект
 * определенным образом. Создайте класс Employee, реализующий интерфейс Measurable.
 * Предоставьте метод double average(Measurable[] objects), вычисляющий среднюю меру.
 * Воспользуйтесь им для расчета средней зарплаты в массиве работников.
 */
public class Task01 {
  public static void main(String[] args) {
    Measurable[] employees = new Employee[6];
    employees[0] = new Employee(300.0);
    employees[1] = new Employee(100.0);
    employees[2] = new Employee(200.0);
    employees[3] = new Employee(350.0);
    employees[4] = new Employee(500.0);
    employees[5] = new Employee(800.0);
    System.out.println(new Task01().average(employees));
  }

  public double average(Measurable[] objects) {
    return Arrays.stream(objects).mapToDouble(Measurable::getMeasure).sum() / objects.length;
  }
}

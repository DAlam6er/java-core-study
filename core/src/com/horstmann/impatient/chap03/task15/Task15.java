package com.horstmann.impatient.chap03.task15;

import java.util.Arrays;

import static java.util.Comparator.comparing;

/**
 * Организуйте вызов метода Arrays.sort(), сортирующего работников сначала по зарплате,
 * а затем по имени. Воспользуйтесь для этой цели методом Comparator.thenComparing().
 */
public class Task15 {
  public static void main(String[] args) {
    Employee employee1 = new Employee("Ivan", 550);
    Employee employee2 = new Employee("Marina", 550);
    Employee employee3 = new Employee("Anton", 900);
    Employee employee4 = new Employee("Kirill", 600);
    Employee employee5 = new Employee("Sveta", 450);
    Employee[] employees = new Employee[]{employee1, employee2, employee3, employee4, employee5};

    System.out.println("Сортировка по возрастанию");
    Arrays.sort(employees, comparing(Employee::getSalary).thenComparing(Employee::getName));
    Arrays.stream(employees).forEach(System.out::println);

    System.out.println("Сортировка по убыванию:");
    Arrays.sort(employees, comparing(Employee::getSalary).thenComparing(Employee::getName).reversed());
    Arrays.stream(employees).forEach(System.out::println);
  }
}

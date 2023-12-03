package com.horstmann.impatient.chap03.task10;

import java.util.Arrays;

/**
 * Реализуйте следующие методы:
 * public static void runTogether(Runnable... tasks)
 * public static void runInOrder(Runnable... tasks)
 * Первый метод должен выполнять каждую задачу в отдельном потоке и возвращать
 * полученный результат, а второй метод - все методы в текущем потоке и возвращать
 * полученный результат по завершении последнего метода.
 */
public class Task10 {
  public static void main(String[] args) {
    Runnable task1 = () -> System.out.println("Hello from " + Thread.currentThread().getName());
    Runnable task2 = () -> System.out.println("Hello from " + Thread.currentThread().getName());
    Runnable task3 = () -> System.out.println("Hello from " + Thread.currentThread().getName());
    Runnable task4 = () -> System.out.println("Hello from " + Thread.currentThread().getName());

    runTogether(task1, task2, task3, task4);
    runInOrder(task1, task2, task3, task4);
  }

  public static void runTogether(Runnable... tasks) {
    Arrays.stream(tasks).forEach(task -> new Thread(task).start());
  }

  public static void runInOrder(Runnable... tasks) {
    Arrays.stream(tasks).forEach(Runnable::run);
  }
}

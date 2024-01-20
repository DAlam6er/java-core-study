package com.horstmann.impatient.chap03.task14;

import java.util.Arrays;

/**
 * Напишите метод, принимающий массив экземпляров типа Runnable и возвращающий
 * экземпляр типа Runnable, метод которого run() выполняет их по порядку.
 * Организуйте возврат лямбда-выражения
 */
public class Task14 {
  public static void main(String[] args) {
    Runnable task1 = () -> System.out.println("Hello from " + Thread.currentThread().getName());
    Runnable task2 = () -> System.out.println("Hello from " + Thread.currentThread().getName());
    Runnable task3 = () -> System.out.println("Hello from " + Thread.currentThread().getName());
    Runnable task4 = () -> System.out.println("Hello from " + Thread.currentThread().getName());
    Thread thread = new Thread(getOrdered(new Runnable[]{task1, task2, task3, task4}));
    thread.start();
  }

  private static Runnable getOrdered(Runnable[] runnables) {

    return () -> Arrays.stream(runnables)
        .forEach(runnable -> {
          Thread thread = new Thread(runnable);
          thread.start();
          try {
            thread.join();
          } catch (InterruptedException ignored) {
          }
        });
  }
}

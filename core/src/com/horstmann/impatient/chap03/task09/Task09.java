package com.horstmann.impatient.chap03.task09;

/**
 * Создайте класс Greeter, реализующий интерфейс Runnable, метод которого run() выводит n раз сообщение "Hello, " + target,
 * где n и target - параметры, устанавливаемые в конструкторе. Получите два экземпляра этого класса с разными сообщениями и выполните их
 * в двух потоках.
 */
public class Task09 {
  public static void main(String[] args) {
    Greeter runnable1 = new Greeter(8, "Vasiliy Ivanovich");
    Greeter runnable2 = new Greeter(4, "Pet'ka");
    new Thread(runnable1).start();
    new Thread(runnable2).start();
  }
}

package com.sedykh.tiktaktok;

import java.util.concurrent.Semaphore;

public class Runner implements Runnable {
  private final Semaphore previous;
  private final Semaphore next;
  private final int[] numbers;
  private final Thread self;

  public Runner(Semaphore previous, Semaphore next, int[] numbers) {
    this.previous = previous;
    this.next = next;
    this.numbers = numbers;
    this.self = new Thread(this);
  }

  @Override
  public void run() {
    for (int number : numbers) {
      wait4Green();
      System.out.printf("%2d(%s)",
          number, Thread.currentThread().getName());
      if ((Main.NUM != number) && (number % 3 != 0)) {
        System.out.print(" - ");
      }
      if (number % 3 == 0) System.out.println();
      switchGreen4Next();
    }
  }

  private void wait4Green() {
    try {
      // Получение разрешения у предыдущего семафора
      previous.acquire();
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }

  private void switchGreen4Next() {
    // освобождаем полученное ранее разрешение для следующего семафора
    next.release();
  }

  public void start() {
    self.start();
  }

  public void join() throws InterruptedException {
    self.join();
  }
}

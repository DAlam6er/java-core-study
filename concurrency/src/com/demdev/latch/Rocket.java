package com.demdev.latch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable {
  private final CountDownLatch countDownLatch;

  public Rocket(CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    System.out.println("Ракета готовится к запуску...");
    try {
      // Ожидаем пока остальные детали не будут сделаны
      countDownLatch.await();
      System.out.println("Пуск!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

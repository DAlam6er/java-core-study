package com.demdev.queu.ver3;


import java.util.concurrent.Semaphore;

public class BuyerThread implements Runnable {
  private final Semaphore cashboxes;

  public BuyerThread(Semaphore cashboxes) {
    this.cashboxes = cashboxes;
  }

  @Override
  public void run() {
    try {
      // захватим монитор
      cashboxes.acquire();

      System.out.println(Thread.currentThread().getName() +
                         " обслуживается в какой-то кассе ");
      Thread.sleep(5L);
      System.out.println(Thread.currentThread().getName() +
                         " освобождаю какую-то кассу ");

      // освобождаем монитор
      cashboxes.release();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

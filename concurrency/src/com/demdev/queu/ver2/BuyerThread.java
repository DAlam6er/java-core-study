package com.demdev.queu.ver2;

import com.demdev.queu.ver1.Cashbox;

import java.util.concurrent.BlockingQueue;

public class BuyerThread implements Runnable {
  private final BlockingQueue<Cashbox> cashboxes;

  public BuyerThread(BlockingQueue<Cashbox> cashboxes) {
    this.cashboxes = cashboxes;
  }

  @Override
  public void run() {
    try {
      // Метод take() получает и удаляет элемент из головы очереди,
      // ожидая при необходимости, пока элемент станет доступным
      // то есть делает и synchronized() и wait()
      Cashbox cashbox = cashboxes.take();
      System.out.println(Thread.currentThread().getName() +
                         " обслуживается в кассе " + cashbox);
      Thread.sleep(5L);
      System.out.println(Thread.currentThread().getName() +
                         " освобождает кассу " + cashbox);
      // возвращаем занятую кассу
      cashboxes.add(cashbox);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

package com.headfirstjava.lostupdate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestLostUpdate_v2 {
  public static void main(String[] args) {
    BalanceIncrement_v2 job = new BalanceIncrement_v2();
    ExecutorService pool = Executors.newFixedThreadPool(6);

    for (int i = 0; i < 1000; i++) {
      pool.execute(() -> job.increment());
    }
    pool.shutdown();
    try {
      if (pool.awaitTermination(1, TimeUnit.MINUTES)) {
        System.out.println("balance = " + job.getBalance());
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class BalanceIncrement_v2 implements Runnable {
  AtomicInteger balance = new AtomicInteger(0);

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      increment();
      System.out.printf("Баланс равен %s(%s)\n",
          balance, Thread.currentThread().getName());
    }
  }

  public void increment() {
    // атомарный пре-инкремент
    balance.incrementAndGet();
  }

  public AtomicInteger getBalance() {
    return balance;
  }
}

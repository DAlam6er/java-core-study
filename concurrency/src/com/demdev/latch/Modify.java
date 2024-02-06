package com.demdev.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Modify {
  private static final AtomicInteger counter1 = new AtomicInteger(0);
  private static final AtomicInteger counter2 = new AtomicInteger(0);

  public static void main(String[] args) throws InterruptedException {
    int tasksCount = 100_000;
    CountDownLatch latch = new CountDownLatch(tasksCount);

    ExecutorService threadPool = Executors.newFixedThreadPool(100);

    for (int i = 0; i < tasksCount; i++) {
      threadPool.submit(() -> {
        counter1.incrementAndGet();
        counter2.incrementAndGet();
        latch.countDown();
      });
    }

    latch.await();

    System.out.println(counter1);
    System.out.println(counter2);
    System.exit(0);
  }
}

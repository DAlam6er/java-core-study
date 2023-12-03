package com.headfirstjava.synchronizethreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchSynchronization {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    // one event we want to wait for (the main thread prints its message)
    // count – the number of times countDown must be invoked before threads can pass through await
    CountDownLatch latch = new CountDownLatch(1);

    executor.execute(() -> waitForLatchThenPrint(latch));

    System.out.println("back in main");
    // Tell the latch to count down when the main method has printed its message
    latch.countDown();

    executor.shutdown();
  }

  private static void waitForLatchThenPrint(CountDownLatch latch) {
    try {
      // wait for the main thread to print out its message
      // this thread will be in a non-runnable state (BLOCKED) while it's waiting
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("top of the stack");
  }
}

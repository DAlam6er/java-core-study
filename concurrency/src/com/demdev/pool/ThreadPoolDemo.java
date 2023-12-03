package com.demdev.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    //fixedThreadPoolTest();
    scheduledThreadPoolTest1();
    ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
    threadPool.scheduleAtFixedRate(() -> System.out.println("OK!"), 2L, 4L, TimeUnit.SECONDS);
    // завершать такой thread pool не следует! т.к. эта задача не висит в очереди
  }

  private static void scheduledThreadPoolTest1() throws InterruptedException {
    ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
    threadPool.schedule(() -> System.out.println("OK!"), 3L, TimeUnit.SECONDS);
    threadPool.shutdown();
    threadPool.awaitTermination(1L, TimeUnit.HOURS);
  }

  private static void fixedThreadPoolTest() throws InterruptedException, ExecutionException {
    ExecutorService threadPool = Executors.newFixedThreadPool(5);
    Future<Integer> future = threadPool.submit(() -> {
      Thread.sleep(2000L);
      System.out.println("It's callable");
      return 1;
    });

    System.out.println("Result: " + future.get());
    // Для закрытия пула
    // ждёт завершения всех задач, отправленных в threadPool
    threadPool.shutdown();
    threadPool.awaitTermination(1L, TimeUnit.HOURS);
    System.out.println("main end");
  }
}

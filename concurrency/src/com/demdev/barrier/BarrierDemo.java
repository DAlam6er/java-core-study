package com.demdev.barrier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BarrierDemo {
  public static void main(String[] args) throws InterruptedException {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(
        RocketDetail.values().length, () -> System.out.println("Пуск"));

    // При таком подходе "зависнем", т.к. в пуле будет всего 2 потока,
    // а деталей у ракеты - 5, следовательно, после окончания работы
    // этих двух потоков - cyclicBarrier не освобождает потоки, которые находятся в пуле.
    // в строке cyclicBarrier.await() класса RocketDetailRunnable
    //ExecutorService threadPool = Executors.newFixedThreadPool(2);
    ExecutorService threadPool = Executors.newCachedThreadPool();

    Arrays.stream(RocketDetail.values())
        .map(detail -> new RocketDetailRunnable(detail, cyclicBarrier))
        .forEach(threadPool::submit);

    threadPool.shutdown();
    threadPool.awaitTermination(1L, TimeUnit.MINUTES);
  }
}

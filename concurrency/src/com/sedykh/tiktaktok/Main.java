package com.sedykh.tiktaktok;

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/*
    Для управления доступом к ресурсу семафор использует счетчик,
    представляющий количество разрешений.
    Если значение счетчика больше нуля, то поток получает доступ к ресурсу,
    при этом счетчик уменьшается на единицу.
    После окончания работы с ресурсом поток освобождает семафор,
    и счетчик увеличивается на единицу.
    Если же счетчик равен нулю, то поток блокируется и ждет,
    пока не получит разрешение от семафора.
 */
public class Main {
  public static final int NUM = 20;

  public static void main(String[] args) {
    try {
      Semaphore sem1 = new Semaphore(1);
      Semaphore sem2 = new Semaphore(1);
      Semaphore sem3 = new Semaphore(1);
      // Получение разрешения у семафора
      sem1.acquire();
      sem2.acquire();
      sem3.acquire();

      int[] nums1 = IntStream.iterate(1, n -> n + 3)
          .limit(NUM / 3 + 1).filter(n -> n <= NUM).toArray();
      int[] nums2 = IntStream.iterate(2, n -> n + 3)
          .limit(NUM / 3 + 1).filter(n -> n <= NUM).toArray();
      int[] nums3 = IntStream.iterate(3, n -> n + 3)
          .limit(NUM / 3 + 1).filter(n -> n <= NUM).toArray();
      Runner runner1 = new Runner(sem3, sem1, nums1);
      Runner runner2 = new Runner(sem1, sem2, nums2);
      Runner runner3 = new Runner(sem2, sem3, nums3);

      runner1.start();
      runner2.start();
      runner3.start();

      // освобождаем полученное ранее разрешение
      sem3.release();

      runner1.join();
      runner2.join();
      runner3.join();
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }
}

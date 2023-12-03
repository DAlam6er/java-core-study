package com.demdev.vol;

public class VolatileDemo {
  /**
   * [RAM flag=false]
   * <p>
   * 1 ------- [flag=false] (кеширование)
   * <p>
   * 2 --------[flag=false], [flag=true]
   */
  private static volatile boolean flag = false;

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      while (!flag) {
        System.out.println("still false");
      }
    });
    thread.start();

    Thread.sleep(5L);

    Thread thread2 = new Thread(() -> {
      flag = true;
      System.out.println("flag is set");
    });
    thread2.start();
  }
}

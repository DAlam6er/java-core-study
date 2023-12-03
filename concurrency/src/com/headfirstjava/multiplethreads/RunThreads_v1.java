package com.headfirstjava.multiplethreads;

public class RunThreads_v1 implements Runnable {
  public static void main(String[] args) {
    RunThreads_v1 runner = new RunThreads_v1();

    Thread alpha = new Thread(runner);
    Thread beta = new Thread(runner);
    alpha.setName("поток альфа");
    beta.setName("поток бета");
    alpha.start();
    beta.start();
  }

  // Вывод непредсказуемый! Всё на усмотрение планировщика потоков
  @Override
  public void run() {
    for (int i = 0; i < 25; i++) {
      String threadName = Thread.currentThread().getName();
      System.out.println("Сейчас работает " + threadName);
    }
  }
}

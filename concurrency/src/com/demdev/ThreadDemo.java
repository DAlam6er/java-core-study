package com.demdev;

public class ThreadDemo {
  public static void main(String[] args) {
    var simpleThread = new SimpleThread();
    System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
    var runnableThread = new Thread(new SimpleRunnable());
    var lambdaThread = new Thread(
        () -> System.out.println("Hello from lambda: " + Thread.currentThread().getName())
    );

    simpleThread.start();
    runnableThread.start();
    lambdaThread.start();
    // Поток, вызвавший метод join() будет ждать до тех пор, пока
    // объект, у которого был вызван этот метод, не закончит своё выполнение
    // Поток будет выполняться до конца run или пока не будет прерван
    try {
      System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
      simpleThread.join(100L);
      System.out.println(simpleThread.getName() + ": " + simpleThread.getState());

      runnableThread.join();
      lambdaThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName());
  }
}

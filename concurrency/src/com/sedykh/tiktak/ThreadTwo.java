package com.sedykh.tiktak;

public class ThreadTwo implements Runnable {
  private final Thread self;
  private final Object monitor;

  public ThreadTwo(Object monitor) {
    this.monitor = monitor;
    self = new Thread(this);
  }

  public Thread getSelf() {
    return self;
  }

  public void start() {
    self.start();
  }

  public void join() throws InterruptedException {
    self.join();
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < TikTak.num; i++) {
        Thread.sleep(1000);
        synchronized (monitor) {
          System.out.println(2);
          monitor.notify();
          if (i < TikTak.num - 1) {
            monitor.wait();
          }
        }
      }
    } catch (InterruptedException ignored) {
    }
  }
}


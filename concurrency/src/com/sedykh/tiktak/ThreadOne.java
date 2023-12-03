package com.sedykh.tiktak;

public class ThreadOne extends Thread {
  private final Object monitor;

  public ThreadOne(Object monitor) {
    this.monitor = monitor;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < TikTak.num; i++) {
        synchronized (monitor) {
          System.out.print(1 + " - ");
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


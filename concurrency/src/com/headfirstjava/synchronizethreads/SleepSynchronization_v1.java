package com.headfirstjava.synchronizethreads;

public class SleepSynchronization_v1 {
  public static void main(String[] args) {
    Runnable theJob = new MyRunnable();
    Thread t = new Thread(theJob);
    t.start();
    System.out.println("back in main");
  }

  static class MyRunnable implements Runnable {
    @Override
    public void run() {
      go();
    }

    public void go() {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("top of the stack");
    }
  }
}

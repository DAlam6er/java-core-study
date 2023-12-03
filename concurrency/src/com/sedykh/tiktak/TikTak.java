package com.sedykh.tiktak;

public class TikTak {
  static final int num = 20;

  public static void main(String[] args) {
    Object monitor = new Object();

    ThreadOne thr1 = new ThreadOne(monitor);
    ThreadTwo thr2 = new ThreadTwo(monitor);

    thr1.start();
    thr2.start();

    try {
      thr1.join();
      thr2.join();
    } catch (InterruptedException ignored) {
    }
  }
}

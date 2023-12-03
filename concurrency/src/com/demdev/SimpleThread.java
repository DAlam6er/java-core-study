package com.demdev;

public class SimpleThread extends Thread {
  @Override
  public void run() {
    System.out.println("Hello from " + Thread.currentThread().getName());
  }
}

package com.sedykh.threadsync;

class Data {
  static int countSt = 0;
  int count = 0;
}

class MyThread implements Runnable {
  private final Data obj;

  MyThread(Data d) {
    obj = d;
    new Thread(this).start();
  }

  static void AddStatic() {
    try {
      //            Thread.sleep(5);
      synchronized (Data.class) { // должен всегда существовать
        int n = Data.countSt;
        n++;
        Thread.sleep(5);
        Data.countSt = n;
      }
    } catch (InterruptedException ignored) {
    }
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      Add();
    }
    for (int i = 0; i < 10; i++) {
      AddStatic();
    }
  }

  void Add() {
    try {
      //            Thread.sleep(5);
      synchronized (obj) {
        int n = obj.count;
        n++;
        Thread.sleep(5);
        obj.count = n;
      }
    } catch (InterruptedException ignored) {
    }
  }
}

public class SyncMain {

  public static void main(String[] args) throws InterruptedException {
    Data d = new Data();
    MyThread t1 = new MyThread(d);
    MyThread t2 = new MyThread(d);

    Thread.sleep(3000);
    System.out.println(d.count);
    System.out.println(Data.countSt);
  }
}


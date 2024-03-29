package com.sedykh.atomictypes;

public class App {
  public static void main(String[] args) {
    CounterThread th1 = new CounterThread();
    CounterThread th2 = new CounterThread();

    th1.start();
    th2.start();

    th1.join();
    th2.join();

    System.out.println("value = " + GlobalData.value);
    // Атомарные типы данных содержат в себе встроенную синхронизацию
    System.out.println("atomic value = " + GlobalData.aValue.get());
  }
}

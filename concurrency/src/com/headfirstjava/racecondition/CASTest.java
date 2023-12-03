package com.headfirstjava.racecondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {
  public static void main(String[] args) {
    BankAccount_v3 account = new BankAccount_v3();
    RyanAndMonicaJob_v3 ryan =
        new RyanAndMonicaJob_v3("Ryan", account, 50);
    RyanAndMonicaJob_v3 monica =
        new RyanAndMonicaJob_v3("Monica", account, 100);
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.execute(ryan);
    executor.execute(monica);
    executor.shutdown();
  }
}

class RyanAndMonicaJob_v3 implements Runnable {
  private final String name;
  private final BankAccount_v3 account;
  private final int amountToSpend;

  RyanAndMonicaJob_v3(String name, BankAccount_v3 account, int amountToSpend) {
    this.name = name;
    this.account = account;
    this.amountToSpend = amountToSpend;
  }

  @Override
  public void run() {
    goShopping(amountToSpend);
  }

  private void goShopping(int amount) {
    if (account.getBalance() >= amount) {
      System.out.println(name + " is about to spend");
      account.spend(name, amount);
      System.out.println(name + " finishes spending");
    } else {
      System.out.println("Sorry, not enough for " + name);
    }
  }
}

class BankAccount_v3 {
  private final AtomicInteger balance = new AtomicInteger(100);

  // not synchronized!
  public void spend(String name, int amount) {
    int expectedBalance = getBalance();
    int newBalance = expectedBalance - amount;
    if (expectedBalance >= amount) {
      // balance will not be changed
      // if the expectedBalance does not match the actual balance right now
      boolean success = balance.compareAndSet(expectedBalance, newBalance);
      if (!success) {
        System.out.println("Sorry " + name + ", you haven't spent the money.");
      }
    } else {
      System.out.println("Sorry, not enough for " + name);
    }
  }

  public int getBalance() {
    return balance.get();
  }
}

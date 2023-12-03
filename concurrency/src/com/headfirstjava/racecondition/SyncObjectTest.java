package com.headfirstjava.racecondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncObjectTest {
  public static void main(String[] args) {
    BankAccount_v2 account = new BankAccount_v2();
    RyanAndMonicaJob_v2 ryan =
        new RyanAndMonicaJob_v2("Ryan", account, 50);
    RyanAndMonicaJob_v2 monica =
        new RyanAndMonicaJob_v2("Monica", account, 100);
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.execute(ryan);
    executor.execute(monica);
    executor.shutdown();
  }
}

class RyanAndMonicaJob_v2 implements Runnable {
  private final String name;
  private final BankAccount_v2 account;
  private final int amountToSpend;

  RyanAndMonicaJob_v2(String name, BankAccount_v2 account, int amountToSpend) {
    this.name = name;
    this.account = account;
    this.amountToSpend = amountToSpend;
  }

  @Override
  public void run() {
    goShopping(amountToSpend);
  }

  /*
  The synchronized keyword locks an object.
  The goShopping() method is in RyanAndMonicaJob.
  Synchronizing an instance method means “lock this RyanAndMonicaJob instance.”
  However, there are two instances of RyanAndMonicaJob;
  one is “ryan,” and the other is “monica.”
  If “ryan” is locked, “monica” can still make changes to the bank account;
  she doesn’t care that the “ryan” job is locked.

  private synchronized void goShopping(int amount) - DOES NOT WORK
   */
  private void goShopping(int amount) {
    // The object that needs locking,
    // the object these two threads are fighting over,
    // is the BankAccount.
    // wrap our shopping transaction in a block that locks the bank account
    synchronized (account) {
      if (account.getBalance() >= amount) {
        System.out.println(name + " is about to spend");
        account.spend(amount);
        System.out.println(name + " finishes spending");
      } else {
        System.out.println("Sorry, not enough for " + name);
      }
    }
  }
}

class BankAccount_v2 {
  private int balance = 100;

  public int getBalance() {
    return balance;
  }

  public void spend(int amount) {
    balance = balance - amount;
    // If we see this message - that means that synchronization failed
    if (balance < 0) {
      System.out.println("Overdrawn!");
    }
  }
}

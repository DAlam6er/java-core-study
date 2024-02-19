package com.examples;

import java.util.ArrayList;
import java.util.List;

public class VolatileTest {
  class Foo {
    int x = 0;
    int y = 0;
  }

  public static void main(String[] args) throws InterruptedException {
    new VolatileTest().runTest();
  }

  public void runTest() throws InterruptedException {
    List<Integer> listOfX = new ArrayList<>();

    for (int i = 0; i < 100_000; i++) {
      Foo foo = new Foo();
      Thread t1 = new Thread(() -> {
        foo.x = 1;
        foo.y = 1;
      });

      Thread t2 = new Thread(() -> {
        while (foo.y != 1) ;
        listOfX.add(foo.x);
      });
      t1.start();
      t2.start();
      t1.join();
      t2.join();
    }
    System.out.println("list contains 0: " + listOfX.contains(0));
  }
}

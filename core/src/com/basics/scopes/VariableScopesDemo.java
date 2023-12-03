package com.basics.scopes;

public class VariableScopesDemo {
  private static final int counter2 = 15;
  private int counter = 10;

  public static void main(String[] args) {
    int counter = 5;
    System.out.println(counter);
    VariableScopesDemo test = new VariableScopesDemo();
    System.out.println(test.counter);
    System.out.println(counter2);
    System.out.println("--------");
    double d = 5;
    System.out.println(d);
  }
}

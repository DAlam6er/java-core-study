package com.collections.arraylistofintprimitives.v1;

import java.util.Arrays;
import java.util.Scanner;

public class App {
  /* Testing of MyIntList implementation */
  public static void main(String[] args) {
    String n;
    Scanner in = new Scanner(System.in);
    MyIntList listOfints = new MyIntList();

    // testing .add() method implementation
    System.out.println("Input integer elements of the list, 'e' to stop:");
    while (true) {
      n = in.nextLine();
      if ("e".equals(n)) {
        break;
      }
      listOfints.add(Integer.parseInt(n));
    }

    // testing .add(index, el) method implementation
    listOfints.add(2, 999);
    System.out.println(
        "Content of the list:\n" + Arrays.toString(listOfints.toArray()));

    // testing .size() method implementation
    System.out.println(
        "Size of the resulting list is " + listOfints.size());

    // testing .get() method implementation
    System.out.print("Input index of the element to get: ");
    System.out.println(
        "Required element is " + listOfints.get(in.nextInt()));

    // testing .remove() method implementation


  }
}

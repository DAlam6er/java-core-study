package com.datatypes.binaryoperations;

import java.util.Scanner;

public class IsPowerOfTwo {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num;
    System.out.print("Input a integer number:");
    num = in.nextInt();
    System.out.println(check(num));
  }

  /**
   * @param inNumber is integer
   * @return true if inNumber is power of 2
   */
  private static boolean check(int inNumber) {
    int num = (inNumber < 0) ? -inNumber : inNumber;
    return (num & (num - 1)) == 0;
  }

  //       (n & -n) == n;
  // 0 0 0 ... 1 0 ... 0 0 0 : n
  // 1 1 1 ... 1 0 ... 0 0 0 : (-n)
  // 0 0 0 ... 1 0 ... 0 0 0


  //      (n & (n-1)) == 0;
  // 0 0 0 ... 1 0 ... 0 0 0 - n
  // 0 0 0 ... 0 1 ... 1 1 1 - (n - 1)

  public static boolean check2powerAlt(int n) {
    if (n == 1)
      return true;
    return Integer.parseInt(Integer.toBinaryString(n).substring(1)) == 0;
  }
}
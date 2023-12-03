package com.datatypes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GCD {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    int y = Integer.parseInt(br.readLine());
    br.close();

    System.out.println(gcd(x, y));
  }

  static int gcd(int firstNum, int secondNum) {
    while (secondNum != 0) {
      int modulo = firstNum % secondNum;
      firstNum = secondNum;
      secondNum = modulo;
    }
    return firstNum;
  }
}

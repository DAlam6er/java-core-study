package com.datatypes.binaryoperations;

import java.util.Scanner;

public class Decimal2BinaryConverter {
  public static final int LENGTH = 32;
  public static final long LIMIT = (long) Math.pow(2, LENGTH) / 2 - 1;

  public static void main(String[] args) {
    System.out.printf("Enter decimal number to convert (from %s to %s): ",
        -1 - LIMIT, LIMIT);
    long numToConvert = new Scanner(System.in).nextLong();

    String binNumber = getBinary(numToConvert);
    String binNumberShort = getBinaryShort(numToConvert);

    System.out.println("Long interpretation:");
    System.out.println(binNumber);
    System.out.println("Short interpretation:");
    System.out.println(binNumberShort);
  }

  public static String getBinary(long num) {
    if ((num < -1 - LIMIT) || (num > LIMIT)) {
      throw new IllegalArgumentException("the entered value is out of range");
    }
    int bitNum, j;
    StringBuilder str = new StringBuilder(LENGTH + LENGTH / 4 - 1);
    for (bitNum = 1, j = 0; bitNum <= LENGTH; bitNum++) {
      if ((num & 1) == 1) {
        str.append("1");
      } else {
        str.append("0");
      }
      num >>= 1;
      if (bitNum == 4 + j * 4 && bitNum != LENGTH) {
        str.append(" ");
        j++;
      }
    }
    return str.reverse().toString();
  }

  public static String getBinaryShort(long num) {
    if ((num < -1 - LIMIT) || (num > LIMIT)) {
      throw new IllegalArgumentException("the entered value is out of range");
    }
    int bitNum;
    StringBuilder str = new StringBuilder(LENGTH + LENGTH / 4 - 1);
    for (bitNum = 1; bitNum <= LENGTH; bitNum++) {
      if (num == 0) {
        break;
      } else if ((num & 1) == 1) {
        str.append("1");
      } else {
        str.append("0");
      }
      num >>= 1;
    }

    if ((str.length() % 4) != 0) {
      int missingZeros = 4 - (str.length() % 4);
      str.append("0".repeat(missingZeros));
    }
    int spacesNum = str.length() / 4 - 1;
    for (int i = 0; i < spacesNum; i++) {
      str.insert(5 * i + 4, ' ');
    }
    return str.reverse().toString();
  }
}

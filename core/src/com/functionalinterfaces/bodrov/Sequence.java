package com.functionalinterfaces.bodrov;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class Sequence {
  //1) Проверка на четность:
  //[1,2,3,4,5] -> [2,4]

  //2) Проверка суммы цифр элемента на четность:
  //[123,104,75, 81, 1, 8] -> [123,75,8]
  public static void main(String[] args) {
    int[] array;
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input number of elements: ");
    int n = scanner.nextInt();
    array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = scanner.nextInt();
    }

    IntPredicate evenNum = num -> 0 == num % 2;
    IntPredicate evenDigSum = num ->
    {
      int testSum = num;
      int res = 0;
      while (testSum != 0) {
        res += testSum % 10;
        testSum /= 10;
      }
      return 0 == res % 2;
    };
    System.out.println("Even numbers: " +
                       Arrays.toString(filter(array, evenNum)));
    System.out.println("Numbers with Even sum of digits: " +
                       Arrays.toString(filter(array, evenDigSum)));
  }

  public static int[] filter(int[] array, IntPredicate predicate) {
    int[] newArray = new int[array.length];
    int top = 0;
    for (int el : array) {
      if (predicate.test(el)) {
        newArray[top++] = el;
      }
    }
    return Arrays.copyOfRange(newArray, 0, top);
  }
}
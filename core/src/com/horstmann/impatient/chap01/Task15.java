package com.horstmann.impatient.chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Напишите программу, сохраняющую треугольник Паскаля вплоть до заданной величины n
 * в переменной типа ArrayList&lt;ArrayList&lt;Integer&gt;&gt;
 */
public class Task15 {
  private static final Integer TRIANGLE_SIZE = 13;
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> triangle = getPascalTriangle(TRIANGLE_SIZE);
    System.out.println("Треугольник Паскаля величины " + TRIANGLE_SIZE);
    for (ArrayList<Integer> elements : triangle) {
      for (Integer element : elements) {
        System.out.printf("%4s ", element);
      }
      System.out.println();
    }
  }

  private static ArrayList<ArrayList<Integer>> getPascalTriangle(int n) {
    ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
    triangle.add(new ArrayList<>(List.of(1)));
    triangle.add(new ArrayList<>(List.of(1, 1)));
    for (int i = 2; i < n; i++) {
      Integer[] triangleBase = new Integer[i + 1];
      triangleBase[0] = 1;
      for (int j = 1; j < triangleBase.length - 1; j++) {
        ArrayList<Integer> previousBase = triangle.get(i - 1);
        triangleBase[j] = previousBase.get(j - 1) + previousBase.get(j);
      }
      triangleBase[triangleBase.length - 1] = 1;
      triangle.add(new ArrayList<>(Arrays.asList(triangleBase)));
    }
    return triangle;
  }
}

package com.arrays;

public class PascaleTriangle {
  public static void main(String[] args) {
    if (args.length != 0) {
      var n = Integer.parseInt(args[0]);
      int[][] triangle = new int[n][];

      for (int i = 0; i < n; i++) {
        triangle[i] = new int[i + 1];
        triangle[i][0] = 1;
        triangle[i][i] = 1;
        for (int j = 1; j < i; j++) {
          triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
        }
      }

      for (int i = 0; i < triangle.length; i++) {
        for (int j = 0; j < triangle[i].length; j++) {
          System.out.printf("%4d", triangle[i][j]);
        }
        System.out.println();
      }
    }
  }
}

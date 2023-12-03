package com.horstmann.impatient.chap01;

/**
 * Усовершенствуйте упоминавшийся ранее метод average() таким образом, чтобы он вызывался
 * хотя бы с одним параметром
 */
public class Task16 {
  public static void main(String[] args) {
    System.out.println(average(1, 2, 3));
    System.out.println(average(1));
  }

  public static double average(double... values) {
    double sum = 0;
    for (double v : values) {
      sum += v;
    }
    return values.length == 0 ? 0 : sum / values.length;
  }
}

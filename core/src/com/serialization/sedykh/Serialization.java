package com.serialization.sedykh;

import java.io.*;
import java.util.Arrays;

public class Serialization {
  public static void main(String[] args) {
    Test test = new Test("Serializable object", 10, 5.5);
    try {
      ObjectOutputStream oos = new ObjectOutputStream(
          new BufferedOutputStream(
              new FileOutputStream("object")));
      oos.writeObject(test);
      oos.close();

      ObjectInputStream ois = new ObjectInputStream(
          new BufferedInputStream(
              new FileInputStream("object")));
      Test rtest = (Test) ois.readObject();
      System.out.println(rtest);
    } catch (IOException | ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    }
  }
}

class Test implements Serializable {
  static double y;
  final int x;
  String name;
  int[] m = {1, 2, 3, 4, 5};

  public Test(String name, int x, double y) {
    this.name = name;
    this.x = x;
    Test.y = y;
  }

  @Override
  public String toString() {
    return "MergeSort{" + "name='" + name + '\'' + ", x=" + x + ", y=" + y +
           ", m=" + Arrays.toString(m) + '}';
  }
}

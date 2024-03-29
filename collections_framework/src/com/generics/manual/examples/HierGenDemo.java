package com.generics.manual.examples;

class Gen<T> {
  T ob;

  Gen(T o) {
    ob = o;
  }

  T getOb() {
    return ob;
  }
}

class Gen2<T, V> extends Gen<T> {
  V ob2;

  Gen2(T o, V o2) {
    super(o);
    ob2 = o2;
  }

  V getOb2() {
    return ob2;
  }
}

public class HierGenDemo {
  public static void main(String[] args) {
    Gen2<String, Integer> x =
        new Gen2<>("Value is: ", 99);

    System.out.print(x.getOb());
    System.out.println(x.getOb2());
  }
}

package com.collections.dmdev.set;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
  public static void main(String[] args) {
    Set<String> set = new HashSet<>();
    System.out.println(set.add("aaa"));
    System.out.println(set.add("bbb"));
    System.out.println(set.add("ccc"));
    System.out.println(set.add("ddd"));
    System.out.println(set.add("bbb"));

    System.out.println(set);
  }
}

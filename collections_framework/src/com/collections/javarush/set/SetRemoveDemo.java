package com.collections.javarush.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetRemoveDemo {
  public static void main(String[] args) {
  }

  public static Set<Integer> createSet() {
    Set<Integer> set = new HashSet<>();
    int el;
    for (int i = 0; i < 20; i++) {
      el = (int) (Math.random() * 20);
      while (set.contains(el)) {
        el = (int) (Math.random() * 20);
      }
      set.add(el);
    }
    return set;
  }

  public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
    Iterator<Integer> iterator = set.iterator();
    while (iterator.hasNext()) {
      if (iterator.next() > 10) iterator.remove();
    }
  }
}

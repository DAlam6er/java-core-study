package com.collections.javarush.arraylistvslinkedlist;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/*
Измерить сколько времени занимает 10 тысяч вызовов get для каждого списка
*/
public class Get10000 {
  public static void main(String[] args) {
    System.out.println(getGetTimeInMs(fill(new ArrayList<>())));
    System.out.println(getGetTimeInMs(fill(new LinkedList<>())));
  }

  public static long getGetTimeInMs(List<Object> list) {
    long start = new Date().getTime();
    get10000(list);
    long finish = new Date().getTime();
    return finish - start;
  }

  public static List<Object> fill(List<Object> list) {
    for (int i = 0; i < 10000; i++) {
      list.add(new Object());
    }
    return list;
  }

  public static void get10000(List<Object> list) {
    if (list.isEmpty()) {
      return;
    }
    int x = list.size() / 2;

    for (int i = 0; i < 10000; i++) {
      list.get(x);
    }
  }
}

package com.collections.javarush.arraylistvslinkedlist;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/*
Измерить сколько времени занимает 10 тысяч вставок для каждого списка
*/
public class Insert10000 {
  public static void main(String[] args) {
    System.out.println(getInsertTimeInMs(new ArrayList<>()));
    System.out.println(getInsertTimeInMs(new LinkedList<>()));
  }

  public static long getInsertTimeInMs(List<Object> list) {
    Calendar calendar = Calendar.getInstance();
    long start = calendar.getTimeInMillis();
    insert10000(list);
    long finish = calendar.getTimeInMillis();
    return finish - start;
  }

  public static void insert10000(List<Object> list) {
    for (int i = 0; i < 10000; i++) {
      list.add(0, new Object());
    }
  }
}

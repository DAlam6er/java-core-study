package com.demdev.list;

import java.util.List;

public class ListThread extends Thread {
  private final List<Integer> list;

  public ListThread(List<Integer> list) {
    this.list = list;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
            /*
            synchronized (list) {
                list.add(i);
            }
             */
      list.add(i);
      // Проблема в том, что нет никаких ограничений на вызов метода
      // list.add() из другого потока
      // поскольку данный метод не синхронизированный
      // т.к. ограничение следующее:
      // если действие, кот. мы хотим совершить с объектом требует захвата монитора
    }
  }
}

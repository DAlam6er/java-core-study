package com.demdev.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
  public static void main(String[] args) throws InterruptedException {
    // Вариант 1. не потокобезопасная коллекция с блоком synchronized в нужном методе
    //List<Integer> integers = new ArrayList<>();

    // Вариант 2. потокобезопасная коллекция - обертка вокруг ArrayList<>()
    // такой способ тоже является неэффективным
    // используется только если используется чужая коллекция, которую нельзя менять
    List<Integer> integers = Collections.synchronizedList(new ArrayList<>());

    ListThread listThread1 = new ListThread(integers);
    ListThread listThread2 = new ListThread(integers);
    ListThread listThread3 = new ListThread(integers);
    ListThread listThread4 = new ListThread(integers);
    ListThread listThread5 = new ListThread(integers);

    listThread1.start();
    listThread2.start();
    listThread3.start();
    listThread4.start();
    listThread5.start();

    listThread1.join();
    listThread2.join();
    listThread3.join();
    listThread4.join();
    listThread5.join();

    System.out.println(integers);
  }
}

package com.demdev.task;

import java.util.Queue;

public class ProducerThread implements Runnable {
  private final Queue<Integer> list;

  public ProducerThread(Queue<Integer> list) {
    this.list = list;
  }

  @Override
  public void run() {
    synchronized (list) {
      while (true) {
        if (list.size() < 10) {
          int random = RandomUtil.getRandom();
          list.add(random);
          System.out.printf("Producer adds value: %d. Size %d\n",
              random, list.size());
        } else {
          System.out.println("Producer does nothing");
        }

        //list.notifyAll();

        try {
          //Thread.sleep(RandomUtil.getRandom());
          // отпустим монитор на время ожидания
          int randomWaitValue = 20;
          System.out.println("Producer waits: " + randomWaitValue);
          list.wait(randomWaitValue);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

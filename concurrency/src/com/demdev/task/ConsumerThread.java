package com.demdev.task;

import java.util.Queue;

public class ConsumerThread implements Runnable {
  private final Queue<Integer> list;

  public ConsumerThread(Queue<Integer> list) {
    this.list = list;
  }

  @Override
  public void run() {
    synchronized (list) {
      while (true) {
        if (!list.isEmpty()) {
          Integer removedValue = list.remove();
          System.out.printf("Consumer get value: %d. Size: %d\n",
              removedValue, list.size());
        } else {
          System.out.println("Consumer is waiting, list is empty");
        }
        try {
          //Thread.sleep(RandomUtil.getRandom());
          int random = 80;
          System.out.println("Consumer wait: " + random);
          //list.notifyAll();
          list.wait(random);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

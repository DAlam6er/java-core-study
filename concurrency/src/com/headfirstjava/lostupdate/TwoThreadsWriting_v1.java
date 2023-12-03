package com.headfirstjava.lostupdate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Demonstration of lost-update problem
public class TwoThreadsWriting_v1 {
  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newFixedThreadPool(2);
    // общий ресурс
    Data_v1 data = new Data_v1();
    threadPool.execute(() -> addLetterToData('a', data));
    threadPool.execute(() -> addLetterToData('A', data));
    threadPool.shutdown();
  }

  private static void addLetterToData(char initialLetter, Data_v1 data) {
    for (int i = 0; i < 26; i++) {
      data.addLetter(initialLetter++);
      try {
        Thread.sleep(50);
      } catch (InterruptedException ignored) {
      }
    }
    System.out.println(Thread.currentThread().getName() + data.getLetters());
    System.out.println(Thread.currentThread().getName()
                       + " size = " + data.getLetters().size());
  }
}

final class Data_v1 {
  private final List<String> letters = new ArrayList<>();

  public List<String> getLetters() {
    return letters;
  }

  // 1. Drawback - is if there's a DIFFERENT thread READING at the same time
  // as one of these threads are writing - THIS WILL NOT WORK
  public synchronized void addLetter(char letter) {
    letters.add(String.valueOf(letter));
  }
}

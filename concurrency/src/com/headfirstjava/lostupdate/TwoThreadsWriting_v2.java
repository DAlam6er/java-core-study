package com.headfirstjava.lostupdate;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Demonstration of lost-update problem
public class TwoThreadsWriting_v2 {
  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newFixedThreadPool(2);
    // общий ресурс
    Data_v2 data = new Data_v2();
    threadPool.execute(() -> addLetterToData('a', data));
    threadPool.execute(() -> addLetterToData('A', data));
    threadPool.shutdown();
  }

  private static void addLetterToData(char initialLetter, Data_v2 data) {
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

final class Data_v2 {
  // using thread-safe collection will allow the threads
  // to both safely write to the letter List
  private final List<String> letters = new CopyOnWriteArrayList<>();

  public List<String> getLetters() {
    return letters;
  }

  public void addLetter(char letter) {
    letters.add(String.valueOf(letter));
  }
}

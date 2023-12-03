package com.headfirstjava;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentReaders {
  public static void main(String[] args) {
    // Stores the Chat Objects in a ArrayList, which is NOT threadsafe
    // List<Chat> chatHistory = new ArrayList<>();
    List<Chat> chatHistory = new CopyOnWriteArrayList<>();
    ExecutorService executor = Executors.newFixedThreadPool(3);
    // one thread - is for writing data
    // two threads - read from the List
    for (int i = 0; i < 5; i++) {
      executor.execute(() -> chatHistory.add(new Chat("Hi there!")));
      // ConcurrentModificationException is thrown here
      executor.execute(() -> System.out.println(chatHistory));
      executor.execute(() -> System.out.println(chatHistory));
    }
    executor.shutdown();
  }
}

// instances of Chat are immutable
final class Chat {
  private final String message;
  private final LocalDateTime timestamp;

  public Chat(String message) {
    this.message = message;
    this.timestamp = LocalDateTime.now();
  }

  @Override
  public String toString() {
    String time =
        timestamp.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
    return time + " " + message;
  }
}

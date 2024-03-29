package com.specialist.sedykh.fxmldemo;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.io.File;

public class FindTask extends Task<Void> {
  private final int SIZE = 200;
  private final ObservableList<String> items;

  private final String path;
  private final String end;

  //private final LinkedList<String> list = new LinkedList<>();

  public FindTask(ObservableList<String> items, String path, String end) {
    this.items = items;
    this.path = path;
    this.end = end;
  }

  // метод вызывается при отмене асинхронной операции
  @Override
  protected void cancelled() {
    items.add("cancelled by user...");
    updateScene();
  }

  // полное выполнение/отмена асинхронной работы
  private void updateScene() {
    updateProgress(SIZE, SIZE);
    System.out.println("Progress updated in thread: " +
                       Thread.currentThread().getName());
  }

  // метод вызывается при успешном окончании асинхронной операции
  @Override
  protected void succeeded() {
        /*
        items.addAll(list);
         */
    items.add(String.format("found %d files", items.size()));
    updateScene();
  }

  @Override
  protected Void call() throws Exception {
    File file = new File(path);
    if (file.isDirectory()) findIn(file);
    return null;
  }

  // синхронный метод
    /*public void doWork()
    {
        File file = new File(path);
        if (file.isDirectory()) findIn(file);
    }
     */

  private void findIn(File file) {
    File[] files =
        file.listFiles(f -> f.getName().endsWith(end) || f.isDirectory());

    if (isCancelled()) return;

        /*
        if (files != null && list.size() < SIZE) {
            for (File f : files) {
                if (f.isDirectory()) {
                    findIn(f);
                } else {
                    list.add(f.getAbsolutePath());
                }
            }
        }
        updateProgress(list.size(), SIZE);
         */

    if (files != null && items.size() < SIZE) {
      for (File f : files) {
        if (f.isDirectory()) {
          findIn(f);
        } else {
          // prints "Thread-3"
          System.out.println(Thread.currentThread().getName());
          // Avoiding java.lang.IllegalStateException: Not on FX application thread
          // Нельзя изменять коллекцию в треде, отличном от JavaFX Application Thread
          Platform.runLater(new Runnable() {
            @Override
            public void run() {
              // prints JavaFX Application Thread
              System.out.println(Thread.currentThread().getName());
              items.add(f.getAbsolutePath());
            }
          });
        }
      }
    }
    updateProgress(items.size(), SIZE);
  }
}

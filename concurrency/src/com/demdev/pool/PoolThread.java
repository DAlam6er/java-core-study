package com.demdev.pool;

import java.util.Optional;
import java.util.Queue;

public class PoolThread extends Thread {
  private final Queue<Runnable> tasks;

  public PoolThread(Queue<Runnable> tasks) {
    this.tasks = tasks;
  }

  @Override
  public void run() {
    while (true) {
      Optional<Runnable> task = Optional.empty();
      // Два потока не смогут в один момент времени получить одну и ту же задачу
      synchronized (tasks) {
        if (!tasks.isEmpty()) {
          task = Optional.of(tasks.remove());
        }
      }
      // в этой точке монитор tasks был освобожден
      task.ifPresent(Runnable::run);
    }
  }
}

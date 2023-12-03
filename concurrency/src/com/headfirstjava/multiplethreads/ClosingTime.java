package com.headfirstjava.multiplethreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ClosingTime {
  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newFixedThreadPool(2);

    threadPool.execute(new LongJob("Long Job"));
    threadPool.execute(new ShortJob("Short Job"));

    // Ask the ExecutorService to shut down.
    // If you call execute() with a job after this, you will get a RejectedExecutionException
    // The ExecutorService will continue to run all the jobs that are running
    // and run any waiting jobs too.
    threadPool.shutdown();

    try {
      // Wait up 5 seconds for the ExecutorService to finish everything
      // If this method hits the timeout before everything has finished, it returns false
      boolean finished = threadPool.awaitTermination(5, TimeUnit.SECONDS);
      System.out.println("Finished? " + finished);
    } catch (InterruptedException e) {
      System.out.println("Method awaitTermination() was interrupted while waiting");
      e.printStackTrace();
    }
    // at this point we tell the ExecutorService to stop everything, right now
    // if everything was already shut down, that's fine; this won't do anything
    threadPool.shutdownNow();
  }

  static class LongJob implements Runnable {
    private final String jobName;

    public LongJob(String jobName) {
      this.jobName = jobName;
    }

    @Override
    public void run() {
      int sum = 0;
      try {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
          TimeUnit.SECONDS.sleep(1);
          sum += i;
        }
      } catch (InterruptedException ex) {
        System.out.println("Job was interrupted from main");
        ex.printStackTrace();
      }
      System.out.println("Counted to " + sum);
    }
  }

  static class ShortJob implements Runnable {
    private final String jobName;

    public ShortJob(String jobName) {
      this.jobName = jobName;
    }

    @Override
    public void run() {
      System.out.printf("%s is running on %s\n",
          jobName, Thread.currentThread().getName());
    }
  }
}

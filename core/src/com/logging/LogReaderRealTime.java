package com.logging;

import java.io.*;
import java.util.concurrent.TimeUnit;

/*
    Вывод файлов протокола на консоль в режиме реального времени
*/
public class LogReaderRealTime {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usage: java LogReaderRealTime <FileName>");
      System.exit(0);
    }
    new LogReaderRealTime().readLogFile(args[0]);
  }

  public void readLogFile(String logFile) {
    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(new FileInputStream(logFile)))) {
      String line;
      while (true) {
        line = br.readLine();
        if (line != null) {
          System.out.println(line);
        } else {
          try {
            TimeUnit.MILLISECONDS.sleep(500);
          } catch (InterruptedException e) {
            System.out.println(e.getMessage());
          }
        }
      }
    } catch (FileNotFoundException e) {
      System.err.println("File not found. \n" + e.getMessage());
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}

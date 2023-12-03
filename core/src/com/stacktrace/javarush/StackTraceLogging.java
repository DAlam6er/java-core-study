package com.stacktrace.javarush;

/*
    Реализовать метод log так, чтобы он выводил на экран имя класса и имя метода
    (в котором вызывается метод log), а также переданное сообщение.
    Имя класса, имя метода и сообщение разделить двоеточием с пробелом.
 */
public class StackTraceLogging {
  public static void main(String[] args) {
    log("In method");
  }

  public static void log(String text) {
    StackTraceElement traceElement =
        Thread.currentThread().getStackTrace()[2];
    String logMessage = String.format("%s: %s: %s",
        traceElement.getClassName(), traceElement.getMethodName(), text);
    System.out.println(logMessage);
  }
}

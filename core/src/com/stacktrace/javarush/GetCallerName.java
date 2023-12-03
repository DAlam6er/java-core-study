package com.stacktrace.javarush;

/*
    Есть пять методов, которые вызывают друг друга.
    Нужно чтобы каждый метод возвращал имя метода, вызвавшего его, полученное с помощью StackTrace.
 */
public class GetCallerName {
  public static void main(String[] args) {
    method1();
    //System.out.println("Inside main after calls.");
  }

  public static String method1() {
    method2();
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    //System.out.println(stackTraceElements[2].getMethodName() + " вызвал method1.");
    return stackTraceElements[2].getMethodName();
  }

  public static String method2() {
    method3();
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    //System.out.println(stackTraceElements[2].getMethodName() + " вызвал method2.");
    return stackTraceElements[2].getMethodName();
  }

  public static String method3() {
    method4();
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    //System.out.println(stackTraceElements[2].getMethodName() + " вызвал method3.");
    return stackTraceElements[2].getMethodName();
  }

  public static String method4() {
    method5();
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    //System.out.println(stackTraceElements[2].getMethodName() + " вызвал method4.");
    return stackTraceElements[2].getMethodName();
  }

  public static String method5() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    //System.out.println(stackTraceElements[2].getMethodName() + " вызвал method5.");
        /*
        System.out.println("\nStackTraceElement content:");
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            System.out.println(stackTraceElement);
        }
        System.out.println();
        */
    return stackTraceElements[2].getMethodName();
  }
}

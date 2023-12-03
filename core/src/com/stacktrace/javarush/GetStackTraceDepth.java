package com.stacktrace.javarush;

/*
    Релизовать метод, который возвращает глубину его стек-трейса
    – количество методов в нем (количество элементов в списке).
    Это же число нужно в методе вывести на экран.
 */
public class GetStackTraceDepth {
  public static void main(String[] args) {
    int deep = getStackTraceDepth();
  }

  public static int getStackTraceDepth() {
    int deep = Thread.currentThread().getStackTrace().length;
    System.out.println(deep);
    return deep;
  }
}

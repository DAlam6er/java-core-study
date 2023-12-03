package com.generics.dmdev.list;

public class ListRunner {
  public static void main(String[] args) {
    List<String> list = new List<>(10);

    list.add("String1");
    // После параметризации можно добавлять только объекты типа String
    //list.add(new Archer("Archer", 20, 10));
    list.add("String2");
    list.add("String3");

    // java.lang.ClassCastException
    // String element = (String)list.get(1);
    // System.out.println(element);
    String element = list.get(0);
    System.out.println(element);
  }
}

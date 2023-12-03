package com.collections.dmdev.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
  public static void main(String[] args) {
    Person first = new Person("Уильям Хартнелл", 67);
    Person second = new Person("Патрик Тротон", 67);
    Person third = new Person("Джон Пертви", 76);
    Person forth = new Person("Том Бейкер", 88);
    Person fifth = new Person("Питер Дэвисон", 71);
    Person sixth = new Person("Колин Бейкер", 79);
    Person seventh = new Person("Сильвестр Маккой", 79);

    Map<String, Person> map = new TreeMap<>();
    map.put(first.getFullName(), first);
    map.put(second.getFullName(), second);
    map.put(third.getFullName(), third);
    map.put(forth.getFullName(), forth);
    map.put(fifth.getFullName(), fifth);
    map.put(sixth.getFullName(), sixth);
    map.put(seventh.getFullName(), seventh);

    for (Map.Entry<String, Person> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " = " + entry.getValue());
    }
  }
}

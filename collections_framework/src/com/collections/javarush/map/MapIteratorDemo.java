package com.collections.javarush.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
    Создать словарь (Map) и занести в него десять записей по принципу:
    «фамилия» - «зарплата».
    Удалить из словаря всех людей, у которых зарплата ниже 500.
 */
public class MapIteratorDemo {
  public static void main(String[] args) {
  }

  public static Map<String, Integer> createMap() {
    Map<String, Integer> salaries = new HashMap<>(10);
    salaries.put("Иванов", 800);
    salaries.put("Петров", 900);
    salaries.put("Сидоров", 1000);
    salaries.put("Козлов", 700);
    salaries.put("Мищенко", 600);
    salaries.put("Трищенко", 500);
    salaries.put("Череззаборкорованогузадерищенко", 400);
    salaries.put("Пушкин", 300);
    salaries.put("Пашкин", 200);
    salaries.put("Чехов", 100);
    return salaries;
  }

  public static void removeItemFromMap(Map<String, Integer> salaries) {
    Iterator<Integer> iterator = salaries.values().iterator();
    while (iterator.hasNext()) {
      if (iterator.next() < 500) iterator.remove();
    }
  }
}

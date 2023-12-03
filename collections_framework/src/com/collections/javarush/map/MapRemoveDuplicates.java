package com.collections.javarush.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    Создать словарь (Map) занести в него десять записей
    по принципу «фамилия» - «имя».
    Удалить людей, имеющих одинаковые имена.
 */
public class MapRemoveDuplicates {
  public static void main(String[] args) {
  }

  public static Map<String, String> createMap() {
    Map<String, String> map = new HashMap<>();
    map.put("Иванов", "Иван");
    map.put("Петров", "Сергей");
    map.put("Сидоров", "Иван");
    map.put("Козлов", "Антон");
    map.put("Мищенко", "Иван");
    map.put("Трищенко", "Пётр");
    map.put("Череззаборкорованогузадерищенко", "Иван");
    map.put("Пушкин", "Кирилл");
    map.put("Пашкин", "Сергей");
    map.put("Чехов", "Антон");
    return map;
  }

  public static void removeTheFirstNameDuplicates(Map<String, String> map) {
    Set<String> dupl = new HashSet<>();
    int cnt = 0;
    for (String compEl : map.values()) {
      for (String el : map.values()) {
        if (el.equals(compEl)) cnt++;
        if (cnt > 1) {
          dupl.add(compEl);
          break;
        }
      }
      cnt = 0;
    }
    for (String removedEl : dupl) {
      removeItemFromMapByValue(map, removedEl);
    }
  }

  public static void removeItemFromMapByValue(Map<String, String> map, String value) {
    Map<String, String> mapCopy = new HashMap<>(map);
    for (Map.Entry<String, String> pair : mapCopy.entrySet()) {
      if (pair.getValue().equals(value)) {
        map.remove(pair.getKey());
      }
    }
  }
}

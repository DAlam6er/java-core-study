package com.collections.dmdev;

import java.util.HashSet;
import java.util.Map;

/**
 * 3. Написать метод isUnique, который принимает Map<String, String>;
 * и возвращает true,
 * если каждому ключу соответствуют свое уникальное значение.
 * Например, в данном случае вернётся true:
 * {Marty=Stepp, Stuart=Reges, Jessica=Miller, Amanda=Camp,
 * Hal=Perkins}
 * А в данном false:
 * {Kendrick=Perkins, Stuart=Reges, Jessica=Miller, Bruce=Reges,
 * Hal=Perkins}
 */
public class IsUniqueMapValues {
  public static void main(String[] args) {
        /*
        Map<String, String> map = new HashMap<>();
        map.put("Marty", "Stepp");
        map.put("Stuart", "Reges");
        map.put("Jessica", "Miller");
        map.put("Amanda", "Camp");
        map.put("Hal", "Perkins");
        */
    Map<String, String> map = Map.of(
        "Marty", "Stepp",
        "Stuart", "Reges",
        "Jessica", "Miller",
        "Amanda", "Camp",
        "Hal", "Perkins"
    );
    System.out.println(isUnique(map));
  }

  public static boolean isUnique(Map<String, String> map) {
    // map.size() - это размер множества ключей
    // сравним его с множеством значений
    return map.size() == new HashSet<>(map.values()).size();
  }
}

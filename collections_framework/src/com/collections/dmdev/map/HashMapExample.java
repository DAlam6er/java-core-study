package com.collections.dmdev.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
  public static void main(String[] args) {
    Person defaultPerson = new Person();
    Person concretePerson =
        new Person("Адриано Челентано", 84);
    Person concretePerson2 =
        new Person("Лучано Паваротти", 72);

    Map<String, Person> map = new HashMap<>();
    map.put(defaultPerson.getFullName(), defaultPerson);
    map.put(concretePerson.getFullName(), concretePerson);
    map.put(concretePerson2.getFullName(), concretePerson2);
    map.putIfAbsent("Адриано Челентано", new Person("Адриано Челентано", 10));

    System.out.println(map.get("Адриано Челентано"));
    System.out.println("--------------------------");
    System.out.println("KeySet: " + map.keySet());
    System.out.println("Values: " + map.values());
    System.out.println(map.entrySet());

    for (Person person : map.values()) {
      System.out.println(person.getFullName());
    }
    System.out.println("----------------------------------");

    for (Map.Entry<String, Person> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
    System.out.println(map.containsKey("Beatles"));
    System.out.println(map.containsKey("Адриано Челентано"));
    System.out.println(map.size());
    System.out.println(map.isEmpty());
    System.out.println(map.getOrDefault("Неизвестный", defaultPerson));
  }
}

package com.collections.dmdev.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
  public static void main(String[] args) {
    Person defaultPerson = new Person();
    Person concretePerson =
        new Person("Адриано Челентано", 84);
    Person concretePerson2 =
        new Person("Лучано Паваротти", 72);

    Map<String, Person> map = new LinkedHashMap<>();
    map.put(defaultPerson.getFullName(), defaultPerson);
    map.put(concretePerson.getFullName(), concretePerson);
    map.put(concretePerson2.getFullName(), concretePerson2);
    map.putIfAbsent("Адриано Челентано", new Person("Адриано Челентано", 10));

    for (Map.Entry<String, Person> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " = " + entry.getValue());
    }
  }
}

package com.collections.dmdev.map;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {
  public static void main(String[] args) {
    List<String> strings = Arrays.asList("123", "345", "14", "678");
    Collections.sort(strings);
    System.out.println(strings);
    System.out.println("-----------------------------------------");

    List<Person> doctorsList = Arrays.asList(
        new Person("Уильям Хартнелл", 67),
        new Person("Патрик Тротон", 67),
        new Person("Джон Пертви", 76),
        new Person("Том Бейкер", 88),
        new Person("Питер Дэвисон", 71),
        new Person("Колин Бейкер", 79),
        new Person("Сильвестр Маккой", 79)
    );
    System.out.println("Sorting, using Comparable interface: ");
    Collections.sort(doctorsList);
    System.out.println(doctorsList);

    System.out.println("Sorting by FullName, using Comparator interface: ");
    Collections.sort(doctorsList, new FullNameComparator());
    System.out.println(doctorsList);

    System.out.println("Sorting by age, using Comparator interface: ");
    doctorsList.sort(new AgeComparator());
    System.out.println(doctorsList);

    // с java 1.8 сортировка с помощью статического метода Comparator
    // без создания самого Comparator
    System.out.println("Sorting first by age, then by full name: ");
    doctorsList
        .sort(Comparator.comparing(Person::getAge)
            .thenComparing(Person::getFullName));
    System.out.println(doctorsList);
  }

  public static class FullNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
      return o1.getFullName().compareTo(o2.getFullName());
    }
  }

  public static class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
      return o1.getAge() - o2.getAge();
    }
  }
}

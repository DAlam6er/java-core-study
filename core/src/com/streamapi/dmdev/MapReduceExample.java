package com.streamapi.dmdev;

import java.util.stream.Stream;

/**
 * Общий список 3_000_000 человек
 * Разбиваем его на 3 части по 1_000_000 человек
 * [1_000_000] -> age -> max -|
 * [1_000_000] -> age -> max -| -> max
 * [1_000_000] -> age -> max -|
 */
public class MapReduceExample {
  public static void main(String[] args) {
    Stream.of(
            new Student(18, "Ivan"),
            new Student(23, "Peter"),
            new Student(34, "Vasya"),
            new Student(45, "Sveta"),
            new Student(20, "Katya"),
            new Student(68, "Den"),
            new Student(101, "Kira")
        )
        //.parallel()                       // обработка в несколько потоков
        .sequential()                       // свернуть вычисление в 1 поток
        .map(Student::getAge)
        //.reduce(0, Integer::sum);
        .reduce(Math::max)
        .ifPresent(System.out::println);
  }
}

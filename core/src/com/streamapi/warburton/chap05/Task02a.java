package com.streamapi.warburton.chap05;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

/**
 * Найдите исполнителя с самым длинным именем.
 * В решении воспользоваться коллектором и функцией высшего порядка reduce.
 * Сравнить обе реализации
 */
public class Task02a {
  private static Comparator<String> comparator = comparingInt(String::length).reversed();

  public static void main(String[] args) {
    Stream<String> names = Stream.of(
        "John Lennon",
        "Paul McCartney",
        "George Harrison",
        "Ringo Starr",
        "Pete Best",
        "Stuart Sutcliffe"
    );
    findArtistWithLongestNameWithReduce(names).ifPresent(System.out::println);
  }


  public static Optional<String> findArtistWithLongestNameWithReduce(Stream<String> names) {
    return names.reduce(Task02a::maxString);
  }

  public static String findLongestNameWithCollector(Stream<String> names) {
    //names.collect(Collectors.maxBy(comparator)).orElse(null);
    return names.sorted(comparator).collect(toList()).getLast();
  }

  private static String maxString(String left, String right) {
    return comparator.compare(left, right) < 0 ? left : right;
  }
}

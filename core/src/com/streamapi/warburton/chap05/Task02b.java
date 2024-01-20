package com.streamapi.warburton.chap05;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Пусть дан поток, элементы которого - слова.
 * Посчитайте, сколько раз встречается каждое слово.
 *
 */
public class Task02b {
  public static void main(String[] args) {
    Stream<String> names = Stream.of(
        "John", "Paul", "George", "John", "Paul", "John"
    );

    Map<String, Long> groups = names.collect(groupingBy(Function.identity(), counting()));
    System.out.println(groups);
  }
}

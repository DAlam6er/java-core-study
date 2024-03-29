package com.streamapi.dmdev;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
  public static void main(String[] args) {
    List<String> strings = List.of("88", "11", "22", "33", "44", "55", "66");
        /*
        for (String string : strings) {
            String value = string + string;
            Integer intValue = Integer.valueOf(value);
            if (intValue % 2 == 0) {
                System.out.println(intValue);
            }
        }
         */
    IntSummaryStatistics intSummaryStatistics = strings.stream()
        .map(string -> string + string)
        .map(Integer::valueOf)
        .filter(value -> value % 2 == 0)
        //.peek(value -> System.out.print(value + " "))
        .sorted()
        .skip(1)
        .limit(2)
        .mapToInt(Integer::intValue)
        .summaryStatistics();
    System.out.println(intSummaryStatistics);
    System.out.println("---------------------------------------------");

    List<String> collect = Stream.of("88", "11", "22", "33", "44", "55", "66")
        .peek(System.out::println)
        .collect(Collectors.toList());
    System.out.println("---------------------------------------------");

    IntStream intStream = IntStream.of(1, 4, 5, 6);

    IntStream.range(0, 10)
        .forEach(System.out::println);
    System.out.println("---------------------------------------------");

    IntStream.iterate(0, operand -> operand + 2)
        .skip(10)
        .limit(20)
        .forEach(System.out::println);
    System.out.println("---------------------------------------------");
  }
}

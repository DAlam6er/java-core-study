package com.streamapi.warburton.chap03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Напишите реализацию метода filter интерфейса Stream, пользуясь только методом reduce и лямбда-выражениями.
 */
public class Task09 {
  public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
    List<I> initial = new ArrayList<>();
    return stream.reduce(
        initial,
        (List<I> accum, I x) -> {
          if (predicate.test(x)) {
            List<I> newAccum = new ArrayList<>(accum);
            newAccum.add(x);
            return newAccum;
          } else {
            return accum;
          }
        },
        // combiner - собирает результат работы accumulator путем сложения списков
        // копируем содержимое левого списка, чтобы избежать его изменения
        (List<I> left, List<I> right) -> {
          List<I> newLeft = new ArrayList<>(left);
          newLeft.addAll(right);
          return newLeft;
        });
  }
}

package com.streamapi.warburton.chap03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Напишите реализацию метода map интерфейса Stream, пользуясь только методом reduce
 * и лямбда-выражениями
 */
public class Task08 {
  public static <I, R> List<R> map(Stream<I> stream, Function<I, R> mapper) {
    return stream.reduce(
        // начальное значение для функции combiner - identity
        new ArrayList<R>(),
        // копируем данные из аккумулятора в новый список, т.к. контракт метода Stream.reduce() не предполагает изменение аргументов (accum, x)
        // метод Stream.collect() был бы более эффективен, но в задаче требуется использовать reduce()
        (List<R> accum, I x) -> {
          List<R> newAccum = new ArrayList<>(accum);
          newAccum.add(mapper.apply(x));
          return newAccum;
        },
        // combiner - собирает результат работы accumulator путем сложения списков
        // копируем содержимое левого списка, чтобы избежать его изменения
        (List<R> left, List<R> right) -> {
          List<R> newList = new ArrayList<>(left);
          newList.addAll(right);
          return newList;
        });
  }
}

package com.generics.dmdev.pair;

/**
 * Создать статический обобщённый метод swap в утилитном классе PairUtil.
 * Метод должен принимать объект класса Pair и возвращать новый объект Pair,
 * в которой элементы поменяны местами.
 */
public final class PairUtil {
  private PairUtil() {
  }

  public static <K, V> Pair<V, K> swap(Pair<K, V> source) {
    K first = source.getFirst();
    V second = source.getSecond();
    return new Pair<>(second, first);
  }
}

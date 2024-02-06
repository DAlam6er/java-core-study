package com.streamapi.warburton.chap09;

import java.util.function.Consumer;

/**
 * Имея API, согласованный с моделью обратных вызовов, мы можем отказаться от
 * последовательного выполнения блокирующих операций поиска.
 * Необходимо воспользоваться классом CompletableFuture, чтобы переработать
 * метод isLargerGroup так, чтобы эти операции выполнялись конкурентно.
 */
public interface ArtistAnalyzer {
  void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler);
}

package com.favourite.wordcounter;

/**
 * Контракт, обеспечивающий паттерн Издатель-Подписчик.
 * <p>
 * Метод counted - событие, которое Издатель (объект класса WordCounted)
 * может рассылать своим Подписчикам.
 */

public interface IWordCounter {
  void counted(Object sender, int size);
}

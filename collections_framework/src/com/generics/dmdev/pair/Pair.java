package com.generics.dmdev.pair;

/**
 * Создать класс Pair, параметризованный двумя параметрами K и V.
 * Класс должен хранить две переменные типов K и V соответственно.
 * У класса должен быть конструктор, принимающий 2 параметра типов K и V,
 * а также набор соответствующих геттеров/сеттеров,
 * toString (для отображения состояния текущего объекта типа Pair)
 */
public class Pair<K, V> {
  private K first;
  private V second;

  public Pair(K first, V second) {
    this.first = first;
    this.second = second;
  }

  public K getFirst() {
    return first;
  }

  public void setFirst(K first) {
    this.first = first;
  }

  public V getSecond() {
    return second;
  }

  public void setSecond(V second) {
    this.second = second;
  }

  @Override
  public String toString() {
    return "Pair{" +
           "first=" + first +
           ", second=" + second +
           '}';
  }
}

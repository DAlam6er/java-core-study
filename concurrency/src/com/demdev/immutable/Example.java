package com.demdev.immutable;

import java.util.ArrayList;
import java.util.List;

public class Example {
  private List<Integer> list;

  public Example(List<Integer> list) {
    // Так коллекция будет mutable, т.е. мы сможем в клиентском коде добавлять новые элементы
    // используя передаваемую как аргумент ссылку list
    this.list = list;

    // Так коллекция будет immutable благодаря инкапсуляции,
    // ссылка list, передаваемая как аргумент не будет вести на поле list
    // Будет выброшено java.lang.UnsupportedOperationException
    // при попытке изменить коллекцию

    //this.list = List.copyOf(list);
  }

  // Возвращаем неизменяемую коллекцию
  public List<Integer> getList() {
    // Вариант 1 - возвращаем неизменяемую коллекцию
    // возможен выброс java.lang.UnsupportedOperationException
    //return list;

    // вариант 2 - возвращаем новую коллекцию на чтение
    return new ArrayList<>(list);
  }
}

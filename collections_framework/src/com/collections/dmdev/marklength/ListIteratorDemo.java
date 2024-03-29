package com.collections.dmdev.marklength;

import java.util.LinkedList;
import java.util.List;

/**
 * Написать метод markLength4, принимающий в качестве параметра список (List) строк
 * и размещающий строку "****" перед каждым четырёхсимвольным элементом.
 * Оригинальные элементы должны остаться на месте.
 * <p>
 * Например:
 * {"this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"}
 * ->
 * {"****", "this", "is", "****", "lots", "of", "fun", "for", "every", "****",
 * "Java", "programmer"}
 */
public class ListIteratorDemo {
  public static void main(String[] args) {
    /*
     * Здесь выбрана реализация списка - LinkedList,
     * потому что предполагается очень большое количество вставок в середину.
     * Это, пожалуй, единственная хорошая причина использовать LinkedList, а не ArrayList.
     */
    List<String> list = new LinkedList<>(List.of(
        "this", "is", "lots", "of", "fun",
        "for", "every", "Java", "programmer")
    );
    MarkLengthUtil.markLength4(list);
    System.out.println(list);
  }
}

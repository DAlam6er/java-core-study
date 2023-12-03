package com.horstmann.impatient.chap02.task10;

import java.util.ArrayList;
import java.util.List;

/**
 * Предоставьте в классе RandomNumbers два статических метода типа
 * randomElement, получающих произвольный элемент из обычного или списочного
 * массива целочисленных значений. (Если обычный или списочный массив пуст,
 * должен быть возвращен нуль.) Почему эти методы нельзя сделать методами экземпляра
 * типа t[] или ArrayList&lt;Integer&gt;?
 */
public class Task10 {
  public static void main(String[] args) {
    int[] integers = new int[]{1, 4, 5, 6, -1, 0};
    System.out.println("Random int from int[] integers: " + RandomNumbers.randomElement(integers));

    List<Integer> integerList = new ArrayList<>(List.of(19, 43, -14, 18, 0, 33));
    System.out.println("Random int from List<Integer> integers: " + RandomNumbers.randomElement(integerList));

    int[] integers2 = new int[0];
    System.out.println("Random int from int[] integers: " + RandomNumbers.randomElement(integers2));
  }
}

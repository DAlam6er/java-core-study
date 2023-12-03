package com.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RecursiveMethods {
  private static List<Integer> list = new ArrayList<>();

  public static void main(String[] args) {
    fillList();
    System.out.println("List content:\n" + list);
    System.out.println("Number of elements is " + size(list));
    System.out.println("Sum of the elements is " + sum(list));
    System.out.println("Max element is " + max(list));
  }

  public static void fillList() {
    try (Scanner in = new Scanner(System.in)) {
      System.out.println(
          "Input numeric elements of the list: ");
      // Читаем строку до нажатия на enter. Парсим и добавляем в list.
      if (in.hasNextLine()) {
        list = Arrays.stream(in.nextLine().split(" "))
            .mapToInt(Integer::parseInt).boxed()
            .collect(Collectors.toList());
      }
    } catch (NumberFormatException ex) {
      System.out.println("Input only numbers!");
      System.exit(1);
    }
    System.out.println();
  }

  public static int sum(List<Integer> list) {
    if (list.size() == 0) return 0;
    return list.get(0) + sum(list.subList(1, list.size()));
  }

  public static int size(List<Integer> list) {
    if (list.size() == 0) return 0;
    return 1 + size(list.subList(1, list.size()));
  }

  public static int max(List<Integer> list) {
    // Базовый случай
    if (list.size() == 2) {
      return Math.max(list.get(1), list.get(0));
    }

    // Рекурсивный случай
    int subMax = max(list.subList(1, list.size()));
    // Метод возвращает большее из 2 значений:
    // 1-й элемент списка в сравнении с результатом предыдущего
    // рекурсивного вызова
    return Math.max(list.get(0), subMax);
  }
}
package com.sortingmethods.javarush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
    Создай список чисел.
    Добавь в список 10 чисел с клавиатуры.
    Вывести на экран длину самой длинной последовательности
    повторяющихся чисел в списке.
    На входе: 2, 4, 4, 4, 8, 8, 4, 12, 12, 14
    На выходе: 3
 */
public class SequenceLength {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      String string = reader.readLine();
      list.add(Integer.parseInt(string));
    }

    int maxLength = 1;
    int curLength = 1;
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i).equals(list.get(i + 1))) {
        curLength++;
      } else if (curLength > maxLength) {
        maxLength = curLength;
        curLength = 1;
      } else {
        curLength = 1;
      }
    }

    // Проверка после последнего шага иетреации
    if (curLength > maxLength) {
      maxLength = curLength;
    }

    System.out.println(maxLength);
  }
}

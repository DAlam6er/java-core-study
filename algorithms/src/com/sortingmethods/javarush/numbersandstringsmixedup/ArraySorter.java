package com.sortingmethods.javarush.numbersandstringsmixedup;

import java.util.ArrayList;
import java.util.Iterator;

public class ArraySorter {

  public void sort2(String[] array) {
    ArrayList<String> listOfNumbers =
        new ArrayList<>(array.length / 2);
    ArrayList<String> listOfWords =
        new ArrayList<>(array.length / 2);

    for (String s : array) {
      if (isNumber(s)) {
        listOfNumbers.add(s);
      } else {
        listOfWords.add(s);
      }
    }

    // Сортируем список чисел
    listOfNumbers.sort(
        (s1, s2) -> Integer.parseInt(s2) - Integer.parseInt(s1));

    // Сортируем список слов
    String temp;
    for (int i = 0; i < listOfWords.size(); i++) {
      for (int j = 0; j < listOfWords.size() - 1 - i; j++) {
        if (isGreaterThan(listOfWords.get(j), listOfWords.get(j + 1))) {
          temp = listOfWords.get(j);
          listOfWords.set(j, listOfWords.get(j + 1));
          listOfWords.set(j + 1, temp);
        }
      }
    }
    // Формируем итоговый массив
    Iterator<String> numIterator = listOfNumbers.iterator();
    Iterator<String> wordsIterator = listOfWords.iterator();
    for (int i = 0; i < array.length; i++) {
      if (isNumber(array[i])) {
        array[i] = numIterator.next();
      } else {
        array[i] = wordsIterator.next();
      }
    }
  }

  // Переданная строка - это число?
  public boolean isNumber(String text) {
    if (text.length() == 0) {
      return false;
    }

    char[] chars = text.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char character = chars[i];
      if ((i != 0 && character == '-') // Строка содержит '-'
          || (!Character.isDigit(character) && character != '-') // или не цифра и не начинается с '-'
          || (chars.length == 1 && character == '-')) // или одиночный '-'
      {
        return false;
      }
    }
    return true;
  }

  // Метод для сравнения строк: 'а' больше чем 'b'
  public boolean isGreaterThan(String a, String b) {
    return a.compareTo(b) > 0;
  }

  public void sort(String[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (isNumber(array[i]) && isNumber(array[j])) {
          if (Integer.parseInt(array[i]) < Integer.parseInt(array[j])) {
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
          }
        } else if (!isNumber(array[i]) && !isNumber(array[j])) {
          if (isGreaterThan(array[i], array[j])) {
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
          }
        }
      }
    }
  }
}

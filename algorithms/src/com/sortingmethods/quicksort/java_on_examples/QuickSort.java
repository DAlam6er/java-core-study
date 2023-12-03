package com.sortingmethods.quicksort.java_on_examples;

public class QuickSort {
  public static void main(String[] args) {
    char[] seq = {'h', 'e', 'd', 'a', 'c', 'i'};

    System.out.print("Исходный порядок символов: ");
    for (char c : seq) {
      System.out.print(c + " ");
    }
    System.out.println();

    QuickSort.sort(seq);

    System.out.print("Сортированный порядок символов: ");
    for (char c : seq) {
      System.out.print(c + " ");
    }
  }

  public static void sort(char[] items) {
    quicksort(items, 0, items.length - 1);
  }


  private static void quicksort(char[] items, int indFrom, int indTo) {
    int firstPos, lastPos;
    char comparand, temp;

    firstPos = indFrom;     // первая позиция
    lastPos = indTo;        // последняя позиция
    // опорный элемент
    comparand = items[(indFrom + indTo) / 2];

    // разделение последовательности на 2 части
    // двигаем указатели навстречу другу другу, пока они не встретятся
    do {
      while ((items[firstPos] < comparand) && (firstPos < indTo)) {
        firstPos++;
      }
      while ((comparand < items[lastPos]) && (lastPos > indFrom)) {
        lastPos--;
      }

      if (firstPos <= lastPos) {
        temp = items[firstPos];
        items[firstPos] = items[lastPos];
        items[lastPos] = temp;
        firstPos++;
        lastPos--;
      }
    } while (firstPos <= lastPos);

    // Промежуточный вариант сортировки
    for (char item : items) {
      System.out.print(item + " ");
    }
    System.out.println();

    // рекурсивная сортировка 1-й части
    if (indFrom < lastPos) quicksort(items, indFrom, lastPos);
    // рекурсивная сортировка 2-й части
    if (firstPos < indTo) quicksort(items, firstPos, indTo);
  }
}

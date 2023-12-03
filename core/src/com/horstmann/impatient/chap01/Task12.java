package com.horstmann.impatient.chap01;

/**
 * В комплект разработки Java Development Kit входит архивный файл src.zip
 * с исходным кодом библиотеки Java. Разархивируйте этот файл и с помощью избранного
 * вами инструментального средства поиска текста найдите в этом исходном коде примеры
 * применения последовательностей операторов break и continue с меткой. Выберите один из
 * этих примеров и перепишите его без оператора с меткой
 */
public class Task12 {
  public static void main(String[] args) {
    breakWithLabel();
    System.out.println("------------");
    breakWithoutLabel();
  }

  private static void breakWithLabel() {
    outer:
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= 10; j++) {
        System.out.printf("%4d", i * j);
        if (i * j == 25) {
          System.out.println();
          break outer;
        }
      }
      System.out.println();
    }
  }

  private static void breakWithoutLabel() {
    boolean iterate = true;
    for (int i = 1; i <= 10 && iterate; i++) {
      for (int j = 1; j <= 10 && iterate; j++) {
        System.out.printf("%4d", i * j);
        if (i * j == 25) {
          iterate = false;
        }
      }
      System.out.println();
    }
  }
}

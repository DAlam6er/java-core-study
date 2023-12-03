package com.functionalinterfaces.dmdev;

import java.util.Comparator;

public class LambdaExamples {
  public static void main(String[] args) {
    // С использованием внутреннего класса
    Comparator<Integer> comparator = new IntegerComparator();
    System.out.println(comparator.compare(25, 100));

    // С использованием анонимного класса
    comparator = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
      }
    };

    // С использованием полной записи лямбда-выражения
    comparator = (Integer o1, Integer o2) -> {
      return Integer.compare(o1, o2);
    };

    // С использованием укороченной записи лямбда-выражения
    comparator = ((o1, o2) -> Integer.compare(o1, o2));
    System.out.println(comparator.compare(25, 100));

    // Можем сослаться на метод compare класса Integer, и сказать, что
    // хотим использовать его как КОМПАРАТОР, т.к. у него один в один
    // совпадает КОЛИЧЕСТВО ПАРАМЕТРОВ (2) и ВОЗВРАЩАЕМЫЙ ТИП - int
    // как и у требуемого компаратора
    // то есть слева от знака "=" находится функциональный интерфейс BiFunction
    // а справа от знака "=" находится функция, инстанцирующая данный интерфейс
    Comparator<Integer> refComparator = Integer::compare;
    System.out.println(refComparator.compare(25, 100));
  }

  private static class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
      return Integer.compare(o1, o2);
    }
    // [модификатор доступа] <возвращаемый тип> <название>([параметры])
    // Для понимания логики метода compare() модификатор доступа не нужен
    // Возвращаемый тип можно определить неявно по возвращаемому значению
    // Название тоже не интересует,
    // т.к. в интерфейсе Comparator всего один нереализованный метод,
    // который требует переопределения
    // Т.о. от метода остается:
    // (Integer o1, Integer o2) {
    //     return Integer.compare(o1, o2);
    // }
  }
}

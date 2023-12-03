package com.collections.dmdev;

import java.util.*;

/**
 * 4. Сложить два многочлена заданной степени, если коэффициенты
 * многочлена хранятся в объекте HashMap в виде:
 * Ключ: номер степени
 * Значение: значение множителя
 * Вывести результирующий многочлен в виде строки: ax^6 + bx^4 +
 * cx^3 + dx + 8
 */
public class PolynomialSum {
  public static void main(String[] args) {
    Map<Integer, Integer> polynomial1 = Map.of(
        0, 5,
        1, 3,
        3, 2,
        5, 4,
        6, 7
    );
    Map<Integer, Integer> polynomial2 = Map.of(
        0, 5,
        3, 4,
        5, 5,
        6, 1
    );
    // 8x^6 + 9x^5 + 6x^3 + 3x^1 + 10
    System.out.println(convertToString(sum(polynomial1, polynomial2)));
  }

  public static String convertToString(Map<Integer, Integer> map) {
    Map<Integer, Integer> result = new TreeMap<>(Comparator.reverseOrder());
    result.putAll(map);
    List<String> list = new ArrayList<>(result.size());
    for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
      String value = entry.getKey() == 0
          ? String.valueOf(entry.getValue())
          : entry.getValue() + "x^" + entry.getKey();
      list.add(value);
    }
    return String.join(" + ", list);
  }

  public static Map<Integer, Integer> sum(Map<Integer, Integer> polynomial1,
                                          Map<Integer, Integer> polynomial2) {
    Map<Integer, Integer> polynomialResult = new HashMap<>(polynomial1);
    for (Map.Entry<Integer, Integer> entry : polynomial2.entrySet()) {
      // Вариант 1
      // Передаем ключ, если по нему ничего не найдено, то вернуть 0
      //Integer value = polynomialResult.getOrDefault(entry.getKey(), 0);
      // Кладём в результат пару "ключ из второй мапы - значение-сумма из 1-го и 2-го полиномов"
      //polynomialResult.put(entry.getKey(), value + entry.getValue());

      // Вариант 2
      // Функция получает ключ, значение, которые нужно положить в map
      // если по указанному ключу уже есть значение,
      // вызывается 3-й аргумент - BiFunction remappingFunction
      // (newValue, oldValue) -> newValue + oldValue
      // где newValue == entry.getValue()
      // oldValue() - значение, которое уже содержалось в polynomialResult
      polynomialResult.merge(entry.getKey(), entry.getValue(), Integer::sum);
    }

    return polynomialResult;
  }

}

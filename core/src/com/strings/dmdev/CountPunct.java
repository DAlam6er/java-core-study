package com.strings.dmdev;

/**
 * 4. Подсчитать количество всех точек, запятых и восклицательных знаков в строке.
 */
public class CountPunct {
  public static void main(String[] args) {
    String value = "asdfsdf.,!asdf.,?sasdf!asdf";
    System.out.println(countSymbols(value));
  }

  public static int countSymbols(String value) {
    // Строки - immutable объекты, т.ч. метод replace возвращает новую строку
    String result = value.replace(".", "")
        .replace(",", "")
        .replace("!", "");
    // сколько символов было заменено
    return value.length() - result.length();
  }
}

package com.regexpressions.dmdev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindExample {
  public static void main(String[] args) {
    String phoneNumber = "asdfafsdasdf+375 (33)898-33-13 asdfasdfg df gdsfg +375 (44) 777-12-13" +
                         "fsadf +375(29) 657-10-29 asdfasdf +375 (25) 111-11-13 asdf";

    // поиск вхождения в начале строки
    //String regex = "^\\+375\\s?\\(\\d{2}\\)\\s?\\d{3}-\\d{2}-\\d{2}";

    // неэкранированные скобки - это обозначение группы
    //String regex = "(\\+375)\\s?\\((\\d{2})\\)\\s?\\d{3}-\\d{2}-\\d{2}";

    // последние две цифры номера соответствуют группе
    // можно сослаться на группу по её индексу \\2 - ссылка на номер группы
    // например: "+375 (29) 657-10-29" будет найдено для следующего регулярного выражения:
    //String regex = "(\\+375)\\s?\\((\\d{2})\\)\\s?\\d{3}-\\d{2}-\\2";

    // задание имени для группы (?<groupName>\\d{2})
    //String regex = "(\\+375)\\s?\\((?<code>\\d{2})\\)\\s?\\d{3}-\\d{2}-\\2";

    // исключение группы из регулярного выражения (?:\\+375)
    //String regex = "(?:\\+375)\\s?\\((?<code>\\d{2})\\)\\s?\\d{3}-\\d{2}-\\1";

    String regex = "(\\+375)\\s?\\((\\d{2})\\)\\s?\\d{3}-\\d{2}-\\d{2}";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(phoneNumber);

    // похож на итератор - переходим по подстрокам
        /*
        while (matcher.find()) {
            System.out.println("Whole substring: " + matcher.group());
            System.out.println("Group by number: " + matcher.group(1));
            System.out.println("Group by name: " + matcher.group("code"));
        }
         */

    // потокобезопасный аналог StringBuilder
    //StringBuffer stringBuffer = new StringBuffer();

    // т.к. используем локальные переменные - они потокобезопасные
    StringBuilder stringBuilder = new StringBuilder();

    while (matcher.find()) {
      // заменяем все строки, которые соответствуют регулярному выражению
      // на XXX
      matcher.appendReplacement(stringBuilder, "XXX");
    }
    // добавляем хвост замененной строки
    matcher.appendTail(stringBuilder);
    System.out.println(stringBuilder);

    regex = "(?:\\+375)\\s?\\((?<code>\\d{2})\\)\\s?(\\d{3})-(\\d{2})-(\\d{2})";
    pattern = Pattern.compile(regex);
    matcher = pattern.matcher(phoneNumber);
    // очищаем объект
    stringBuilder.setLength(0);
    while (matcher.find()) {
      String gr1 = matcher.group(2);
      String gr2 = matcher.group(3);
      String gr3 = matcher.group(4);
      // оставляем только номер телефона без кода, и заменяем тире пробелами

      // через конкатенацию групп
      //matcher.appendReplacement(stringBuilder, gr1 + " " + gr2 + " " + gr3);

      // через ссылки на группы $grNumber
      matcher.appendReplacement(stringBuilder, "$2 $3 $4");
    }
    matcher.appendTail(stringBuilder);
    System.out.println(stringBuilder);

    // Еще более простой способ замены, используя класс String
    System.out.println(phoneNumber.replaceAll(regex, "$2 $3 $4"));
  }
}

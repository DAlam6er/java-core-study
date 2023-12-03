package com.regexpressions.dmdev.tasks;

/**
 * 3. Написать программу, выполняющую поиск в строке всех тегов
 * абзацев, в т.ч. тех, у которых есть параметры, например <p id="p1">,
 * и замену их на простые теги абзацев <p>.
 */
public class Task3 {
  public static void main(String[] args) {
    //String regex = "(<p .+>)(.+</p>)";
    // p .+> "+" жадный квантификатор, он проглотил строку
    // <p id ="p1"> sometext </p>five <p>six seven <p id="p2">
    // .+ идёт до конца строки, потом возвращается, пока на наткнется на закрывающий тег >


    // .+?< находит вхождение и прекращает поиск - ленивый
    // поиск с проверкой на каждом шаге, идет ли после любого символа знак <
    String regex = "(<p .+?>)(.+?</p>)";
    String input = "<p>one bike, </p> <b> two </b>  three four " +
                   "<p id =\"p1\"> sometext </p>five <p>six seven <p id=\"p2\">sometext</p>nine";
    System.out.println(input.replaceAll(regex, "<p>$2"));
  }
}

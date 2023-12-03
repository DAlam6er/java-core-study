package com.horstmann.impatient.chap02.task17;

/**
 * Предоставьте итератор - объект, извлекающий по порядку элементы очереди из предыдущего
 * упражнения. Сделайте класс Iterator вложенным и определите в нем методы next() и
 * hasNext(). Определите в классе Queue метод iterator(), возвращающий ссылку на объект
 * Queue.Iterator. Должен ли внутренний класс Iterator быть статическим?
 */
public class Task17 {
  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.add("1");
    queue.add("2");
    queue.add("3");
    queue.add("4");
    queue.add("5");
    Queue.Iterator iterator = queue.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}

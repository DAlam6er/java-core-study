package com.horstmann.impatient.chap02.task16;

/**
 * Реализуйте в классе Queue неограниченную очередь символьных строк.
 * Предоставьте метод add() для ввода элемента в хвост очереди и метод remove()
 * для удаления элемента из головы очереди. Организуйте хранение элементов в виде связного
 * списка узлов, создав вложенный класс Node. Должен ли этот класс быть статическим?
 */
public class Task16 {
  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.add("1");
    queue.add("2");
    queue.add("3");
    queue.add("4");
    queue.add("5");
    System.out.println(queue);
    queue.add("6");
    System.out.println(queue);
    queue.remove();
    System.out.println(queue);
    queue.remove();
    System.out.println(queue);
    queue.remove();
    System.out.println(queue);
    queue.remove();
    System.out.println(queue);
    queue.remove();
    System.out.println(queue);
    queue.remove();
  }
}

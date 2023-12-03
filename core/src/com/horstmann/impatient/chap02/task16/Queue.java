package com.horstmann.impatient.chap02.task16;

public class Queue {
  private Node currentNode;

  public Queue() {
    currentNode = null;
  }

  /**
   * Добавление элемента в хвост очереди
   *
   * @param item добавляемый элемент - строка
   */
  public void add(String item) {
    Node newNode;
    if (currentNode == null) {
      newNode = new Node(null, item, null);
    } else {
      newNode = new Node(currentNode, item, null);
      currentNode.next = newNode;
    }
    currentNode = newNode;
  }

  /**
   * Удаление элемента из головы очереди
   */
  public void remove() {
    if (currentNode == null) {
      System.out.println("Очередь пустая, удаление элемента невозможно.");
    } else if (currentNode.prev == null) {
      currentNode = null;
    } else {
      while (currentNode.prev.prev != null) {
        currentNode = currentNode.prev;
      }
      currentNode.prev.next = null;
      currentNode.prev = null;
      while (currentNode.next != null) {
        currentNode = currentNode.next;
      }
    }
  }

  @Override
  public String toString() {
    if (currentNode == null) {
      return null;
    } else {
      Node tmp = new Node(currentNode.prev, currentNode.item, currentNode.next);
      StringBuilder sb = new StringBuilder();
      while (currentNode.prev != null) {
        sb.append(currentNode.item).append("-->");
        currentNode = currentNode.prev;
      }
      sb.append(currentNode.item);
      currentNode = tmp;
      return sb.reverse().toString().replace(">--", "-->");
    }
  }

  private static class Node {
    String item;
    Node next;
    Node prev;

    Node(Node prev, String item, Node next) {
      this.prev = prev;
      this.item = item;
      this.next = next;
    }
  }
}

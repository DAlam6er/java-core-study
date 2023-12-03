package com.queue;

import com.graphs.bfs.DataStructure;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Implementation of FIFO data structure type
 */
public class Queue<T> implements DataStructure<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private Object[] array;
  private int tail;
  private int count; // number of elements in queue

  public Queue() {
    this(DEFAULT_CAPACITY);
  }

  public Queue(int size) {
    array = new Object[size];
    tail = -1;
    count = 0;
  }

  public Queue(T[] array) {
    this.array = array.clone();
    tail = array.length - 1;
    count = array.length;
  }

  @Override
  public void push(T data) {
    if (tail == DEFAULT_CAPACITY - 1) {
      int newLength = 2 * array.length;
      array = Arrays.copyOf(array, newLength);
    }
    array[++tail] = data;
    count++;
  }

  @Override
  public T pop() {
    if (isEmpty()) throw new EmptyStackException();
    T tmp = element();
    System.arraycopy(
        array, 1, array, 0, array.length - 1);
    count--;
    tail--;
    return tmp;
  }

  // Safe because push(T) is type checked
  @SuppressWarnings("unchecked")
  private T element() {
    return (T) array[0];
  }

  @Override
  public T peek() {
    if (isEmpty()) throw new EmptyStackException();
    return element();
  }

  @Override
  public boolean isEmpty() {
    return (count == 0);
  }
}
package com.stack;

import com.graphs.bfs.DataStructure;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> implements DataStructure<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private int topOfStack;
  private Object[] array;

  public Stack() {
    array = new Object[DEFAULT_CAPACITY];
    topOfStack = -1;
  }

  @Override
  public void push(T v) {
    if (topOfStack == array.length - 1) {
      int newLength = 2 * array.length;
      array = Arrays.copyOf(array, newLength);
    }
    array[++topOfStack] = v;
  }

  @Override
  public T pop() {
    if (isEmpty()) throw new EmptyStackException();
    return element(topOfStack--);
  }

  // Safe because push(T) is type checked
  @SuppressWarnings("unchecked")
  private T element(int index) {
    return (T) array[index];
  }

  @Override
  public T peek() {
    if (isEmpty()) throw new EmptyStackException();
    return element(topOfStack);
  }

  @Override
  public boolean isEmpty() {
    return (topOfStack == -1);
  }

  @Override
  public String toString() {
    return String.format("%s; Stack top at %d",
        Arrays.toString(array), topOfStack);
  }
}

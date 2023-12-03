package com.generics.dmdev.list;

import java.util.Iterator;

public class List<T> implements Iterable<T> {
  private T[] objects;
  private int size;

  public List(int initialSize) {
    this.objects = (T[]) new Object[initialSize];
  }

  @Override
  public Iterator<T> iterator() {
    return new ListIterator();
  }

  public void add(T element) {
    objects[size++] = element;
  }

  public T get(int index) {
    return objects[index];
  }

  public int getSize() {
    return size;
  }

  private class ListIterator implements Iterator<T> {
    private int currentIndex = 0;

    @Override
    public boolean hasNext() {
      return currentIndex < size;
    }

    @Override
    public T next() {
      return objects[currentIndex++];
    }
  }
}

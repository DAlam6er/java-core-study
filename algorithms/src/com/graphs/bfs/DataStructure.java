package com.graphs.bfs;

public interface DataStructure<T> {
  void push(T data);

  T pop();

  T peek();

  boolean isEmpty();
}

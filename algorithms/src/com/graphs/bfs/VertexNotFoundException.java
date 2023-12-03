package com.graphs.bfs;

public class VertexNotFoundException extends Exception {
  private final String name;

  public VertexNotFoundException(String message, String name) {
    super(String.format("%s: %s", message, name));
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

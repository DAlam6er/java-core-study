package com.headfirstjava.immutable;

// we don't want to allow subclasses that might add mutable values,
// so make this immutable class final
public final class ImmutableData {
  private final String name;
  private final int value;

  public ImmutableData(String name, int value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public int getValue() {
    return value;
  }
}

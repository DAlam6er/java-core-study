package com.generics.headfirst.examples;

abstract class Animal {
  void eat() {
    System.out.println("Животное ест.");
  }
}

class Dog extends Animal {
  void bark() {
  }

  @Override
  void eat() {
    System.out.println("Собака грызёт кость.");
  }
}

class Cat extends Animal {
  void meow() {
  }

  @Override
  void eat() {
    System.out.println("Кошка ест сухой корм.");
  }
}

package com.oop.dmdev.game.subjects;

public interface Mortal {
  boolean isAlive();

  void takeDamage(int damage);

  String getName();
}

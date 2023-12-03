package com.oop.dmdev.game.subjects;

public class Orc extends Enemy {
  private static final String DEFAULT_NAME = "Орк";
  private static final int DEFAULT_DAMAGE = 15;
  private static final int DEFAULT_HEALTH = 100;

  public Orc(String name, int health, int damage) {
    super(name, health, damage);
  }

  public Orc() {
    super(DEFAULT_NAME, DEFAULT_HEALTH, DEFAULT_DAMAGE);
  }

  @Override
  public void attack(Mortal hero) {
    System.out.println(getName() + " бьёт палицей " + hero.getName());
    hero.takeDamage(getDamage());
  }
}

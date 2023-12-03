package com.oop.dmdev.game.subjects;

import java.util.Random;

public class Zombie extends Enemy {
  private static final String DEFAULT_NAME = "Зомби";
  private static final int DEFAULT_DAMAGE = 15;
  private static final int DEFAULT_HEALTH = 100;

  private int initialHealth;

  public Zombie(String name, int health, int damage) {
    super(name, health, damage);
    this.initialHealth = health;
  }

  public Zombie() {
    super(DEFAULT_NAME, DEFAULT_HEALTH, DEFAULT_DAMAGE);
  }

  @Override
  public void attack(Mortal hero) {
    System.out.println(getName() + " кусает за плечо " + hero.getName());
    hero.takeDamage(getDamage());
  }

  @Override
  public void takeDamage(int damage) {
    super.takeDamage(damage);
    if (!isAlive()) {
      boolean chance = new Random().nextBoolean();
      if (chance) resurrect();
    }
  }

  private void resurrect() {
    setHealth(initialHealth);
    System.out.println("Зомби воскрес");
  }
}

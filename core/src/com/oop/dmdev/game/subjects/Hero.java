package com.oop.dmdev.game.subjects;

import com.oop.dmdev.game.weapons.Weapon;

public abstract class Hero<T extends Weapon> implements Mortal, Attacking {
  private final String name;
  private int health;
  //private final int damage;
  private T weapon;

  public Hero(String name, int health) {
    this.name = name;
    this.health = health;
  }

  public int getDamage() {
    return getWeapon().getDamage();
  }

  @Override
  public void takeDamage(int damage) {
    if (isAlive() && (health <= damage)) {
      health = 0;
      System.out.printf("%s получил урон %d. %s погиб.\n",
          name, damage, name);
    } else {
      health -= Math.min(health, damage);
      System.out.printf("%s получил урон %d. Осталось %d\n",
          name, damage, health);
    }
  }

  public T getWeapon() {
    return weapon;
  }

  public void setWeapon(T weapon) {
    this.weapon = weapon;
  }

  @Override
  public boolean isAlive() {
    return health > 0;
  }

  @Override
  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }
}

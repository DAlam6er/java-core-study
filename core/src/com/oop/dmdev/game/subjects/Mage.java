package com.oop.dmdev.game.subjects;

import com.oop.dmdev.game.weapons.MagicWeapon;

public class Mage<T extends MagicWeapon> extends Hero<T> {
  public Mage(String name, int health) {
    super(name, health);
  }

  @Override
  public void attack(Mortal enemy) {
    System.out.println(getName() + " сотворил заклинание на " + enemy.getName());
    enemy.takeDamage(getDamage());
  }
}

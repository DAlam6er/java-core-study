package com.oop.dmdev.game.subjects;

import com.oop.dmdev.game.weapons.MeleeWeapon;

public class Warrior<T extends MeleeWeapon> extends Hero<T> {
  public Warrior(String name, int health) {
    super(name, health);
  }

  @Override
  public void attack(Mortal enemy) {
    System.out.println(getName() + " взмахнул мечом на " + enemy.getName());
    enemy.takeDamage(getDamage());
  }
}

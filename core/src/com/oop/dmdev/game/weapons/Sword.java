package com.oop.dmdev.game.weapons;

public class Sword implements MeleeWeapon {
  private int damage;

  public Sword(int damage) {
    this.damage = damage;
  }

  public Sword() {
  }

  @Override
  public int getDamage() {
    return 15;
  }

  @Override
  public void setDamage(int damage) {
    this.damage = damage;
  }
}

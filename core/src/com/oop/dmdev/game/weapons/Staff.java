package com.oop.dmdev.game.weapons;

public class Staff implements MagicWeapon {
  private int damage;

  public Staff(int damage) {
    this.damage = damage;
  }

  public Staff() {
  }

  @Override
  public int getDamage() {
    return 20;
  }

  @Override
  public void setDamage(int damage) {
    this.damage = damage;
  }
}

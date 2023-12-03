package com.oop.dmdev.game.weapons;

public class Bow implements RangeWeapon {
  private int damage;

  public Bow(int damage) {
    this.damage = damage;
  }

  public Bow() {
  }

  @Override
  public int getDamage() {
    return 10;
  }

  @Override
  public void setDamage(int damage) {
    this.damage = damage;
  }
}

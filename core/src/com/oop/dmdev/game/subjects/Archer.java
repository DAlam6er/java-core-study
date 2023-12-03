package com.oop.dmdev.game.subjects;

import com.oop.dmdev.game.weapons.RangeWeapon;

public class Archer<T extends RangeWeapon> extends Hero<T> {
  private final Wolf pet;

  public Archer(String name, int health) {
    super(name, health);
    this.pet = new Wolf("Дрогг", 7, 100);
  }

  @Override
  public void attack(Mortal enemy) {
    System.out.println(getName() + " стрельнул из лука в " + enemy.getName());
    pet.attack(enemy);
  }

  class Wolf implements Mortal, Attacking {
    private final String name;
    private final int damage;
    private int health;


    public Wolf(String name, int damage, int health) {
      this.name = name;
      this.damage = damage;
      this.health = health;
    }

    @Override
    public void attack(Mortal enemy) {
      System.out.printf("%s и %s наносят %s совместный урон. ",
          getName(), Archer.this.getName(), enemy.getName());
      enemy.takeDamage(damage + Archer.this.getDamage());
    }

    @Override
    public boolean isAlive() {
      return health > 0;
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

    @Override
    public String getName() {
      return "Питомец " + name;
    }
  }
}

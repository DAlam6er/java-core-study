package com.oop.dmdev.game;

import com.oop.dmdev.game.subjects.Enemy;
import com.oop.dmdev.game.subjects.Hero;
import com.oop.dmdev.game.subjects.Orc;
import com.oop.dmdev.game.subjects.Warrior;
import com.oop.dmdev.game.weapons.Sword;

public class BattleGround {
  public static void main(String[] args) {
    Hero<Sword> warrior = new Warrior<>("Арагорн", 300);
    warrior.setWeapon(new Sword(10));
    Enemy enemy = new Orc("Орк", 175, 15);

    while (enemy.isAlive() && warrior.isAlive()) {
      if (warrior.isAlive()) {
        warrior.attack(enemy);
      }
      if (enemy.isAlive()) {
        enemy.attack(warrior);
      }
    }
  }
}

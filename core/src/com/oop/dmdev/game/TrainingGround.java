package com.oop.dmdev.game;

import com.oop.dmdev.game.subjects.*;
import com.oop.dmdev.game.weapons.Bow;
import com.oop.dmdev.game.weapons.Staff;
import com.oop.dmdev.game.weapons.Sword;

public class TrainingGround {
  public static void main(String[] args) {
    Hero<Sword> warrior = new Warrior<>("Арагорн", 300);
    warrior.setWeapon(new Sword(15));
    //warrior.attackEnemy();

    Hero<Staff> mage = new Mage<>("Гэндальф", 500);
    mage.setWeapon(new Staff(20));
    //mage.attackEnemy();

    Hero<Bow> archer = new Archer<>("Леголас", 200);
    archer.setWeapon(new Bow(10));
    //archer.attackEnemy();

    //Archer.Wolf wolf = ((Archer)archer).new Wolf("test wolf", 11, 2);

    Enemy enemy = new Zombie("Зомби", 100, 10);

    fightWithEnemy(enemy, warrior, mage, archer);
  }

  public static void fightWithEnemy(Enemy enemy, Hero... heroes) {
    while (enemy.isAlive() && anyOfHeroesAlive(heroes)) {
      for (Hero hero : heroes) {
        if (enemy.isAlive() && hero.isAlive()) {
          hero.attack(enemy);
        }
        if (enemy.isAlive() && hero.isAlive()) {
          enemy.attack(hero);
        }
      }
    }
  }

  public static boolean anyOfHeroesAlive(Hero... heroes) {
    for (Hero hero : heroes) {
      if (hero.isAlive()) return true;
    }
    System.out.println("Все герои мертвы.");
    return false;
  }
}

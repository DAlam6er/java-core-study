package com.oop.dmdev.game;

import com.oop.dmdev.game.subjects.Archer;
import com.oop.dmdev.game.subjects.Hero;
import com.oop.dmdev.game.subjects.Mage;
import com.oop.dmdev.game.subjects.Warrior;
import com.oop.dmdev.game.weapons.*;

public class WeaponRunner {
  public static void main(String[] args) {
    Archer<Bow> archer = new Archer<>("Леголас", 20);
    archer.setWeapon(new Bow(15));

    Warrior<Sword> warrior = new Warrior<>("Боромир", 30);
    warrior.setWeapon(new Sword(10));

    Mage<MagicWeapon> mage = new Mage<>("Гэндальф", 100);
    mage.setWeapon(new Staff(20));

    printDamage(archer);

  }

  // Можно передать Archer, Warrior, Mage, т.к. они наследуют Hero
  // но если метод принимает Hero<Weapon>, то передать мы можем только
  // тот тип, которым параметризовани Hero
  // Archer<Weapon>, Warrior<Weapon>, Mage<Weapon>, Hero<Weapon>
    /*
    public static void printWeaponDamage(Hero<Weapon> hero)
    {
        System.out.println(hero.getDamage());
    }
     */
  // Вариант 1
  public static <T extends Weapon> void printDamage(Hero<T> hero) {
    System.out.println(hero.getDamage());
  }

  // Вариант 2
  public static void printDamage2(Hero<? extends Weapon> hero) {
    // hero is Producer(Supplier)
    Weapon weapon = hero.getWeapon();
    // Ошибка компиляции
    //hero.setWeapon(new Sword());
    System.out.println(hero.getDamage());
  }

  // Вариант 3
  public static void printDamage3(Hero<? super MeleeWeapon> hero) {
    // hero is Consumer
    hero.setWeapon(new Sword());
    // Ошибка компиляции
    // Sword weapon = hero.getWeapon();
    System.out.println(hero.getDamage());
  }
}

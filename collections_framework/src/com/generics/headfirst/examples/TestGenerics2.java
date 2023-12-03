package com.generics.headfirst.examples;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics2 {
  public static void main(String[] args) {
    new TestGenerics2().go();
  }

  public void go() {
    List<Animal> animals = new ArrayList<>();
    animals.add(new Dog());
    animals.add(new Cat());
    animals.add(new Dog());
    takeAnimals(animals);

    List<Dog> dogs = new ArrayList<>();
    dogs.add(new Dog());
    dogs.add(new Dog());

    // Ошибка времени компиляции
    // List<Dog> cannot be converted to List<Animal>
    // метод принимает в качестве аргумента СТРОГО List<Animal>
    //        takeAnimals(dogs);
  }

  // Полиморфический метод - принимает в качестве параметра родителя
  public void takeAnimals(List<Animal> animals) {
    // Могло бы привести к проблеме,
    // если бы компилятор разрешал методу принимать List<Dog>
    // поскольку привело бы к ситуации,
    // когда передаём список собак, а в списке откуда-то взялась кошка
    // т.о. обеспечивается БЕЗОПАСНОСТЬ типов
    animals.add(new Cat());

    for (Animal animal : animals) {
      animal.eat();
    }
  }
}

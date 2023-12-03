package com.generics.headfirst.examples;

public class TestGenerics1 {
  public static void main(String[] args) {
    new TestGenerics1().go();
  }

  public void go() {
    // Полиморфизм в действии:
    Animal[] animals = {new Dog(), new Dog(), new Cat(), new Cat()};
    System.out.println(
        "Ниже передается массив животных (как кошек, так и собак):");
    takeAnimals(animals);

    Dog[] dogs = {new Dog(), new Dog(), new Dog()};
    System.out.println(
        "\nНиже передается массив собак:");
    // Здесь никакой ошибки не будет
    takeAnimals(dogs);
  }

  // Полиморфический метод - принимает в качестве параметра родителя
  public void takeAnimals(Animal[] animals) {
    // с точки зрения компилятора - всё в порядке
    // но в runtime будет выброшена ошибка java.lang.ArrayStoreException
    // т.к. под animals скрывается Dog[], который может содержать
    // только объекты Dog
    animals[0] = new Cat();

    for (Animal animal : animals) {
      animal.eat();
    }
  }
}
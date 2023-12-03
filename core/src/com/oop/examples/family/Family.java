package com.oop.examples.family;

/*
    Создай класс Human с полями
        имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
    Создай объекты и заполни их так, чтобы получилось:
        Два дедушки, две бабушки, отец, мать, трое детей.
    Вывести объекты на экран.
*/

public class Family {

  public static void main(String[] args) {
    Human grFather1 = new Human("Степан", true, 80);
    Human grFather2 = new Human("Акакий", true, 74);
    Human grMother1 = new Human("Анна", false, 60);
    Human grMother2 = new Human("Василиса", false, 65);

    Human father = new Human("Николай", true, 50,
        grFather1, grMother1);
    Human mother = new Human("Елена", false, 45,
        grFather2, grMother2);
    Human child1 = new Human("Пётр", true, 25,
        father, mother);
    Human child2 = new Human("Варвара", false, 22,
        father, mother);
    Human child3 = new Human("Екатерина", false, 18,
        father, mother);

    System.out.println(grFather1);
    System.out.println(grMother1);
    System.out.println(grFather2);
    System.out.println(grMother2);
    System.out.println(father);
    System.out.println(mother);
    System.out.println(child1);
    System.out.println(child2);
    System.out.println(child3);
  }

  public static class Human {
    private final String name;
    private final boolean sex;
    private final int age;
    private Human father;
    private Human mother;

    public Human(String name, boolean sex, int age) {
      this.name = name;
      this.sex = sex;
      this.age = age;
    }

    public Human(String name, boolean sex, int age,
                 Human father, Human mother) {
      this.name = name;
      this.sex = sex;
      this.age = age;
      this.father = father;
      this.mother = mother;
    }

    public String toString() {
      String text = "";
      text += "Имя: " + this.name;
      text += ", пол: " + (this.sex ? "мужской" : "женский");
      text += ", возраст: " + this.age;

      if (this.father != null) {
        text += ", отец: " + this.father.name;
      }

      if (this.mother != null) {
        text += ", мать: " + this.mother.name;
      }

      return text;
    }
  }
}

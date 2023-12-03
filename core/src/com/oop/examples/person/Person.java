package com.oop.examples.person;

import java.util.Objects;

class App {
  public static void main(String[] args) {
    Person defaultPerson = new Person();
    Person concretePerson =
        new Person("Адриано Челентано", 84);
    Person concretePerson2 =
        new Person("Адриано Челентано", 84);

    defaultPerson.move();
    concretePerson.move();
    defaultPerson.talk();
    concretePerson.talk();
    System.out.println("--------------------------------");
    System.out.println(defaultPerson.hashCode());
    System.out.println(concretePerson.hashCode());
    System.out.println(defaultPerson.equals(concretePerson));
    System.out.println("--------------------------------");
    System.out.println(concretePerson2.hashCode());
    System.out.println(concretePerson.equals(concretePerson2));
  }
}

public class Person {
  private String fullName;
  private int age;

  public Person() {
    this.fullName = "John Doe";
    this.age = 18;
  }

  public Person(String fullName, int age) {
    this.fullName = fullName;
    this.age = age;
  }

  public void move() {
    System.out.printf("%s двигается.\n", this.getFullName());
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void talk() {
    System.out.printf("%s говорит.\n", this.getFullName());
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = (age < 0) ? -age : age;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullName, age);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age && Objects.equals(fullName, person.fullName);
  }

  @Override
  public String toString() {
    return "Person{" +
           "fullName='" + fullName + '\'' +
           ", age=" + age +
           '}';
  }
}

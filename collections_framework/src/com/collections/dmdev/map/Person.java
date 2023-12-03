package com.collections.dmdev.map;

import java.util.Objects;

public class Person implements Comparable<Person> {
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

  @Override
  public int compareTo(Person person) {
    return fullName.compareTo(person.fullName);
  }
}

package com.streamapi.dmdev.stream_examples;

import java.util.Objects;

public class Person {
  private String firstName;
  private String lastName;
  private int age;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, age);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age &&
           firstName.equals(person.firstName) &&
           lastName.equals(person.lastName);
  }

  @Override
  public String toString() {
    return String.format("%s — %d лет", getFullName(), getAge());
  }

  public String getFullName() {
    return firstName + " " + lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = (age < 0) ? -age : age;
  }
}

package com.serialization.dmdev;

import java.io.Serial;
import java.io.Serializable;

enum Sex {
  MALE, FEMALE
}

public class Person implements Serializable {
  @Serial
  private static final long serialVersionUID = 3352356272930753973L;

  private final int age;
  private final String firstName;
  private final transient Sex sex;

  public Person(int age, String firstName, Sex sex) {
    this.age = age;
    this.firstName = firstName;
    this.sex = sex;
  }

  public int getAge() {
    return age;
  }

  public String getFirstName() {
    return firstName;
  }

  @Override
  public String toString() {
    return "Person{" +
           "age=" + age +
           ", firstName='" + firstName + '\'' +
           ", sex=" + sex +
           '}';
  }
}

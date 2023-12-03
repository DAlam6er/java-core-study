package com.streamapi.dmdev;

import java.util.ArrayList;
import java.util.List;

public class Student {
  private final int age;
  private final String name;
  private List<Integer> marks = new ArrayList<>();

  public Student(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public List<Integer> getMarks() {
    return marks;
  }

  @Override
  public String toString() {
    return "Student{" +
           "age=" + age +
           ", name='" + name + '\'' +
           '}';
  }
}

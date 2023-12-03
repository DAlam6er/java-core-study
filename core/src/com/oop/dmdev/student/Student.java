package com.oop.dmdev.student;

public class Student {
  private final String firstName;
  private final String lastName;
  private final int age;
  private final double averageMark;

  public Student(String firstName, String lastName, int age, double averageMark) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.averageMark = averageMark;
  }

  public String getFullName() {
    return getFirstName() + " " + getLastName();
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public double getAverageMark() {
    return averageMark;
  }

  @Override
  public String toString() {
    return "Student{" +
           "firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", age=" + age +
           ", averageMark=" + averageMark +
           '}';
  }
}

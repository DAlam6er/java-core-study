package com.specialist.bodrov.singleton;

public class Human {
  public static final String DEFAULT_NAME = "Default Name";

  static {
    //        System.out.println("Class Human loaded");
  }

  private String name;
  private int age;

  {
    //        System.out.println("New human created");
  }

  public Human(String name, int age) {
    this(name);
    setAge(age);
  }

  public Human(String name) {
    this();
    setName(name);
    setAge(0);
  }

  public Human() {
    //        System.out.println("Constructor called");
    setName(DEFAULT_NAME);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name != null && !name.isBlank()) {
      this.name = name;
    }
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if (age >= 0)
      this.age = age;
  }

  public void sayName() {
    System.out.println("Hello my name is " + name);
  }
}



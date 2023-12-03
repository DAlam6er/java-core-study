package com.horstmann.impatient.chap02;

/**
 * Может ли модифицирующий метод вообще возвращать что-нибудь кроме типа void?
 * Можно ли создать метод доступа с возвращаемым типом void, т.е. ничего фактически не возвращающий?
 * Приведите по возможности примеры таких методов.
 * <p>
 * Создать метод доступа с возвращающим типом void - нельзя.
 */
public class Task3 {
  static Person person;
  static Person personCopy;

  public static void main(String[] args) {
    boolean isChanged = setAge(-12);
    System.out.printf("Person age is %d. Person age was changed: %b\n", person == null ? 0 : person.getAge(), isChanged);
    isChanged = setAge(34);
    System.out.printf("Person age is %d. Person age was changed: %b\n", person == null ? 0 : person.getAge(), isChanged);
  }

  /**
   * Пример модифицирующего метода, возвращающего значение логического типа
   *
   * @param age возраст человека
   * @return результат изменения возраста человека
   */
  private static boolean setAge(int age) {
    if (age < 0) {
      return false;
    } else {
      person = new Person();
      person.setAge(age);
      return true;
    }
  }

  private static class Person {
    int age;
    String name;

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }
  }
}

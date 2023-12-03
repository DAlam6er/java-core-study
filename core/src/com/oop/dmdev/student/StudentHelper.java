package com.oop.dmdev.student;

import java.util.List;

/**
 * Создать класс Student, представляющий собой ученика.
 * Добавить ему данные об имени, фамилии, возрасте и среднем балле за год.
 * Создать список (List) учеников.
 * <p>
 * Найти и вывести ученика с самым высоким средним баллом используя итератор.
 * <p>
 * Отсортировать и вывести список учеников
 * по полному имени (имя + фамилия), возрасту и среднему баллу,
 * используя компараторы.
 */
public final class StudentHelper {
  private StudentHelper() {
  }

  /**
   * Всегда нужно быть аккуратным с коллекциями, ибо они могут приходить пустыми.
   * Следовательно, нельзя брать первые элемент из этой коллекции
   * без предварительной проверки, что он существует
   */
  public static Student getTheBestStudent(List<Student> students) {
    Student theBestStudent = null;
    for (Student student : students) {
      if (theBestStudent == null ||
          theBestStudent.getAverageMark() < student.getAverageMark()) {
        theBestStudent = student;
      }
    }
    return theBestStudent;
  }
}

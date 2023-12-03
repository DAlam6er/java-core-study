package com.oop.dmdev.student;

import com.oop.dmdev.student.comparators.StudentAgeComparator;
import com.oop.dmdev.student.comparators.StudentFullNameComparator;
import com.oop.dmdev.student.comparators.StudentMarkComparator;

import java.util.Arrays;
import java.util.List;

public class StudentDemo {
  public static void main(String[] args) {
    List<Student> students = Arrays.asList(
        new Student("Ivan", "Ivanov", 33, 5.4),
        new Student("Ivan", "Ivanov", 20, 9.7),
        new Student("Sveta", "Svetislav", 18, 7.2),
        new Student("Petr", "Petrov", 25, 8.5),
        new Student("Petr", "Petrov", 25, 8.9),
        new Student("Mike", "Glotov", 31, 6.6)
    );
    System.out.println("Best student:");
    System.out.println(StudentHelper.getTheBestStudent(students));

    students.sort(new StudentFullNameComparator());
    System.out.println("Sorted by full name:");
    System.out.println(students);

    students.sort(new StudentAgeComparator());
    System.out.println("Sorted by age:");
    System.out.println(students);

    students.sort(new StudentMarkComparator());
    System.out.println("Sorted by average mark:");
    System.out.println(students);

    students.sort(
        new StudentFullNameComparator()
            .thenComparing(new StudentAgeComparator()));
    System.out.println("Sorted first by full name then by age:");
    System.out.println(students);
  }
}

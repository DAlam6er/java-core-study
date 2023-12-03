package com.oop.dmdev.student.comparators;

import com.oop.dmdev.student.Student;

import java.util.Comparator;

public class StudentFullNameComparator implements Comparator<Student> {
  @Override
  public int compare(Student o1, Student o2) {
    return o1.getFullName().compareTo(o2.getFullName());
  }
}

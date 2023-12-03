package com.oop.dmdev.student.comparators;

import com.oop.dmdev.student.Student;

import java.util.Comparator;

public class StudentMarkComparator implements Comparator<Student> {
  @Override
  public int compare(Student o1, Student o2) {
    return Double.compare(o1.getAverageMark(), o2.getAverageMark());
  }
}

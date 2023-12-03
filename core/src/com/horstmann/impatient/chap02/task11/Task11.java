package com.horstmann.impatient.chap02.task11;

import java.time.temporal.WeekFields;

/**
 * Перепишите класс Cal, чтобы использовать в нем статический импорт классов
 * System и LocalDate
 */
public class Task11 {
  public static void main(String[] args) {
    Cal.printCurrentMonth(WeekFields.ISO);
  }
}

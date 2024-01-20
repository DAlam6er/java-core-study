package com.horstmann.impatient.chap02.task01;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

/**
 * Измените представленную в этой главе программу вывода календаря таким образом,
 * чтобы неделя начиналась с воскресенья. Кроме того, организуйте перевод на новую строку
 * в конце предыдущей, но только один раз.
 */
public class Task01 {
  public static void main(String[] args) {
    printCurrentMonth(WeekFields.ISO);
    printCurrentMonth(WeekFields.SUNDAY_START);
  }

  private static void printCurrentMonth(WeekFields weekFields) {
    LocalDate currentMonthDate = LocalDate.now().minusMonths(2).withDayOfMonth(1);
    int month = currentMonthDate.getMonthValue();

    DayOfWeek firstDayOfWeek = weekFields.getFirstDayOfWeek();
    for (int i = 0; i < DayOfWeek.values().length; i++) {
      if (i == DayOfWeek.values().length - 1) {
        System.out.printf("%s", firstDayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
      } else {
        System.out.printf("%s ", firstDayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
      }
      firstDayOfWeek = firstDayOfWeek.plus(1);
    }
    System.out.println();

    int i = 0;
    if (firstDayOfWeek == DayOfWeek.MONDAY) {
      i = 1;
    }
    while (i < currentMonthDate.getDayOfWeek().getValue()) {
      System.out.print("    ");
      i++;
    }

    while (currentMonthDate.getMonthValue() == month) {
      if (currentMonthDate.equals(currentMonthDate.with(TemporalAdjusters.lastDayOfMonth()))) {
        System.out.printf("%2d\n", currentMonthDate.getDayOfMonth());
        System.out.println();
        break;
      }
      if (currentMonthDate.getDayOfWeek() == weekFields.getFirstDayOfWeek().plus(6)) {
        System.out.printf("%2d", currentMonthDate.getDayOfMonth());
        System.out.println();
      } else {
        System.out.printf("%2d  ", currentMonthDate.getDayOfMonth());
      }
      currentMonthDate = currentMonthDate.plusDays(1);
    }
  }
}

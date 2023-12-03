package com.horstmann.impatient.chap02.task11;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static java.lang.System.out;
import static java.time.LocalDate.now;

public class Cal {
  public static void printCurrentMonth(WeekFields weekFields) {
    LocalDate currentDate = now().withDayOfMonth(1);
    int month = currentDate.getMonthValue();

    DayOfWeek firstDayOfWeek = weekFields.getFirstDayOfWeek();
    for (int i = 0; i < DayOfWeek.values().length; i++) {
      if (i == DayOfWeek.values().length - 1) {
        out.printf("%s", firstDayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
      } else {
        out.printf("%s ", firstDayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
      }
      firstDayOfWeek = firstDayOfWeek.plus(1);
    }
    out.println();

    int i = 0;
    if (firstDayOfWeek == DayOfWeek.MONDAY) {
      i = 1;
    }
    while (i < currentDate.getDayOfWeek().getValue()) {
      out.print("    ");
      i++;
    }

    while (currentDate.getMonthValue() == month) {
      if (currentDate.equals(currentDate.with(TemporalAdjusters.lastDayOfMonth()))) {
        out.printf("%2d\n", currentDate.getDayOfMonth());
        out.println();
        break;
      }
      if (currentDate.getDayOfWeek() == weekFields.getFirstDayOfWeek().plus(6)) {
        out.printf("%2d", currentDate.getDayOfMonth());
        out.println();
      } else {
        out.printf("%2d  ", currentDate.getDayOfMonth());
      }
      currentDate = currentDate.plusDays(1);
    }
  }
}

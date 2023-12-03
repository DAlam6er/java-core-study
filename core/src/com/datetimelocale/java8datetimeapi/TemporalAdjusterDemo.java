package com.datetimelocale.java8datetimeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Написать свою реализацию интерфейса TemporalAdjuster,
 * которая бы изменяла дату на ближайшее (в днях) 1 января
 */
public class TemporalAdjusterDemo {
  public static void main(String[] args) {
    LocalDateTime localDateTime = LocalDateTime.of(
        LocalDate.of(2018, 7, 27),
        LocalTime.MIDNIGHT);
    LocalDateTime result = adjustToNearestYear(localDateTime);
    System.out.println(result);
  }

  private static LocalDateTime adjustToNearestYear(LocalDateTime localDateTime) {
    TemporalAdjuster temporalAdjuster = temporal -> {
      Temporal currentYear = temporal.with(TemporalAdjusters.firstDayOfYear());
      Temporal nextYear = temporal.with(TemporalAdjusters.firstDayOfNextYear());

      long betweenCurrentYear = ChronoUnit.DAYS.between(currentYear, temporal);
      long betweenNextYear = ChronoUnit.DAYS.between(temporal, nextYear);
      return betweenCurrentYear < betweenNextYear ? currentYear : nextYear;
    };
    return localDateTime.with(temporalAdjuster);
  }
}

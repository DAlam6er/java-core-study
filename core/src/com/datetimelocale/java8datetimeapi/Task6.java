package com.datetimelocale.java8datetimeapi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 6. Даны два объекта LocalDate из предыдущего задания. Подсчитать количество
 * секунд между полуночью первой даты и полуночью второй даты.
 */
public class Task6 {
  public static void main(String[] args) {
    LocalDate now = LocalDate.now();
    LocalDate prevDate = LocalDate.of(2018, 7, 7);

    LocalDateTime.of(now, LocalTime.MIDNIGHT);
    LocalDateTime localDateTimeNow = now.atStartOfDay();
    LocalDateTime localDateTimePrev = prevDate.atStartOfDay();

    Duration duration = Duration.between(localDateTimePrev, localDateTimeNow);
    System.out.println(duration.getSeconds());
  }
}

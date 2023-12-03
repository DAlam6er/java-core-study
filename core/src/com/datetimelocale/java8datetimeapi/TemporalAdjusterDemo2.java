package com.datetimelocale.java8datetimeapi;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;

/**
 * Написать свою реализацию интерфейса TemporalAdjuster, которая бы
 * прибавляла к дате 42 дня
 */
public class TemporalAdjusterDemo2 {
  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();

    // с помощью TemporalAdjuster можно работать на уровне базового класса Temporal,
    // чтобы изменять любой объект из нашей иерархий дат и времени
    TemporalAdjuster temporalAdjuster =
        temporal -> temporal.plus(42L, ChronoUnit.DAYS);
    LocalDateTime localDateTime = now.with(temporalAdjuster);
    System.out.println(localDateTime);
  }
}

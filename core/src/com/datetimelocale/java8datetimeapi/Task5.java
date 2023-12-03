package com.datetimelocale.java8datetimeapi;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 5. Создать объект LocalDate, представляющий собой сегодняшнюю
 * дату. Создать объект LocalDate, представляющий собой дату
 * 07.07.2018. Используя созданные объекты, найти количество дней между
 * этими двумя датами.
 */
public class Task5 {
  public static void main(String[] args) {
    LocalDate now = LocalDate.now();
    LocalDate prevDate = LocalDate.of(2018, 7, 7);

    Period period = Period.between(prevDate, now);
    // Общий период состоит из годов, месяцев, дней
    System.out.println(period.getYears());
    System.out.println(period.getMonths());
    System.out.println(period.getDays());
    // Годы, месяцы и дни, приведенные к одной переменной
    long days = ChronoUnit.DAYS.between(prevDate, now);
    System.out.println(days);
  }
}

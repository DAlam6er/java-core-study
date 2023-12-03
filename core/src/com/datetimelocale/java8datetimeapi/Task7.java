package com.datetimelocale.java8datetimeapi;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 7. Создать объект Instant. Вывести его на консоль. Затем создать
 * объект ZonedDateTime на основании предыдущего объекта с тайм зоной "Africa/Cairo".
 */
public class Task7 {
  public static void main(String[] args) {
    Instant now = Instant.now();
    System.out.println(now);

    ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Africa/Cairo"));
    System.out.println(zonedDateTime);
  }
}

package com.datetimelocale.simpledateformat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatePartDemo {
  private final Date fromDate;
  private final SimpleDateFormat formatter;

  public DatePartDemo(Date fromDate) {
    this.fromDate = fromDate;
    formatter = new SimpleDateFormat(
        "EEE MMM dd hh:mm:ss yyyy", Locale.getDefault());
  }

  public static void main(String[] args) {
    Date currentDate = new Date();
    DatePartDemo dp = new DatePartDemo(currentDate);
    int month = dp.getMonth();

    System.out.println("Текущий месяц: " + month);
  }

  public int getMonth() {
    formatter.applyPattern("M");
    return Integer.parseInt(formatter.format(fromDate));
  }

  public int getDay() {
    formatter.applyPattern("d");
    return Integer.parseInt(formatter.format(fromDate));
  }

  public int getYear() {
    formatter.applyPattern("y");
    return Integer.parseInt(formatter.format(fromDate));
  }

  public int getHour() {
    formatter.applyPattern("h");
    return Integer.parseInt(formatter.format(fromDate));
  }

  public int getMinute() {
    formatter.applyPattern("m");
    return Integer.parseInt(formatter.format(fromDate));
  }
}

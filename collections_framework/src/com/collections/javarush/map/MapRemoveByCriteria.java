package com.collections.javarush.map;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
    В словарь (Map<String, Date>) занести десять записей по принципу:
    «фамилия» - «дата рождения».
    Удалить из словаря всех людей, родившихся летом.
 */
public class MapRemoveByCriteria {
  public static Map<String, Date> createMap() throws ParseException {
    DateFormat dateFormat =
        new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
    Map<String, Date> map = new HashMap<>();
    map.put("Иванов", dateFormat.parse("MAY 1 2012"));
    map.put("Петров", dateFormat.parse("JUNE 1 2012"));
    map.put("Сидоров", dateFormat.parse("JULY 1 2012"));
    map.put("Козлов", dateFormat.parse("AUGUST 1 2012"));
    map.put("Мищенко", dateFormat.parse("MAY 1 2012"));
    map.put("Трищенко", dateFormat.parse("MAY 1 2012"));
    map.put("Череззаборкорованогузадерищенко",
        dateFormat.parse("JUNE 1 2012"));
    map.put("Пушкин", dateFormat.parse("JANUARY 1 2012"));
    map.put("Пашкин", dateFormat.parse("FEBRUARY 1 2012"));
    map.put("Чехов", dateFormat.parse("JULY 1 2012"));
    return map;
  }

  public static void removeAllSummerPeople(Map<String, Date> map) {
    Iterator<Date> iterator = map.values().iterator();
    while (iterator.hasNext()) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(iterator.next());
      int birthMonth = calendar.get(Calendar.MONTH);
      if ((birthMonth == Calendar.JUNE)
          || (birthMonth == Calendar.JULY)
          || (birthMonth == Calendar.AUGUST)) {
        iterator.remove();
      }
    }
  }

  public static void main(String[] args) {
  }
}

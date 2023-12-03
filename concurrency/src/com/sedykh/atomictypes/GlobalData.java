package com.sedykh.atomictypes;

import java.util.concurrent.atomic.AtomicInteger;

public class GlobalData // коллекция глобальных переменных
{
  public static final int STEPS = 1000;
  public static int value;
  public static AtomicInteger aValue = new AtomicInteger();
}

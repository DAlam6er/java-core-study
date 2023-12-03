package com.reflection.dmdev.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
    ElementType.TYPE,
    ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
public @interface MinAge {
  // не требует указания параметра при вызове: @MinAge
  //int age() default 18;

  // требует указания имени метода при вызове: @MinAge(age = 21)
  //int age();

  // зарезервированное имя метода, не требующее указания имени
  int value();
}

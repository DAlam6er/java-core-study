package com.reflection.dmdev;

import com.reflection.dmdev.model.User;

import java.lang.reflect.*;

public class ReflectionAPIExample {
  public static void main(String[] args)
      throws InvocationTargetException, NoSuchMethodException,
      InstantiationException, IllegalAccessException {
    User user = new User(25L, "Ivan", 24);
    Class<? extends User> userClass = user.getClass();
    Class<User> userClass1 = User.class;
    System.out.println(userClass == userClass1);

    testConstructor();
    testFields(user);
    testMethods(user);
  }

  private static void testConstructor()
      throws NoSuchMethodException, InvocationTargetException,
      InstantiationException, IllegalAccessException {
    Constructor<User> constructor =
        User.class.getConstructor(Long.class, String.class, int.class);
    User petr = constructor.newInstance(5L, "Petr", 40);
    System.out.println(petr);
  }

  private static void testFields(Object object) throws IllegalAccessException {
    Field[] declaredFields = object.getClass().getSuperclass().getDeclaredFields();
    for (Field declaredField : declaredFields) {
      // без этой строки будет выброшено IllegalAccessException
      declaredField.setAccessible(true);
      Object value = declaredField.get(object);
      System.out.println(Modifier.isPrivate(declaredField.getModifiers()));
      System.out.println(value);
    }

  }

  private static void testMethods(User user)
      throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
    Method method = user.getClass().getDeclaredMethod("getName");
    System.out.println(method.invoke(user));

    method = user.getClass().getDeclaredMethod("setName", String.class);
    method.invoke(user, "Sveta");
    System.out.println(user);
  }

  private enum Test2 {ONE, TWO}

  private static class Test3 {
  }

  private class Test1 {
  }
}

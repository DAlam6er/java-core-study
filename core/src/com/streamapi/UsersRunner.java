package com.streamapi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class UsersRunner {
  public static void main(String[] args) {
    List<User> users = List.of(
        new User(1, "Анна", "Королёва", LocalDate.of(1991, 2, 26)),
        new User(2, "Анна", "Иванова", LocalDate.of(1995, 2, 15)),
        new User(3, "Кирилл", "Топоров", LocalDate.of(1990, 2, 19)));

    List<User> uniqueUsers = users.stream()
        .collect(groupingBy(User::name, maxBy(comparingInt(User::id))))
        .values() // Collection<Optional<User>>
        .stream() // Stream<Optional<User>>
        .map(user -> user.orElse(null)) // Stream<User>
        .toList();

    Collection<User> uniqueUsers2 = users.stream()
        .collect(groupingBy(User::name, collectingAndThen(maxBy(comparingInt(User::id)), Optional::get)))
        .values();

    Collection<User> uniqueUsers3 = users.stream()
        .collect(toMap(
            User::name, Function.identity(),
            BinaryOperator.maxBy(comparingInt(User::id))))
        .values();

    List<User> test = new ArrayList<>(uniqueUsers3);

    System.out.println(test);
  }

  record User(int id, String name, String surname, LocalDate birthday){}
}

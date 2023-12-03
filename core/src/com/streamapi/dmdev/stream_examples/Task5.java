package com.streamapi.dmdev.stream_examples;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * 5. Дан класс Person с полями firstName, lastName,
 * age.
 * Вывести полное имя самого старшего человека, у
 * которого длина этого имени не превышает 15
 * символов.
 */
public class Task5 {
  public static void main(String[] args) {
    List<Person> doctors = List.of(
        new Person("Уильям", "Хартнелл", 55),
        new Person("Патрик", "Траутон", 46),
        new Person("Джон", "Пертви", 50),
        new Person("Том", "Бейкер", 40),
        new Person("Питер", "Дэвисон", 29),
        new Person("Колин", "Бейкер", 40),
        new Person("Сильвестр", "Маккой", 44),
        new Person("Пол", "Макганн", 36),
        new Person("Кристофер", "Экклстон", 41),
        new Person("Дэвид", "Теннант", 34),
        new Person("Мэтт", "Смит", 27),
        new Person("Питер", "Капальди", 55),
        new Person("Джоди", "Уиттакер", 35)
    );

    doctors.stream()
        .filter(person -> person.getFullName().length() < 15)
        .max(Comparator.comparing(Person::getAge))
        .map(Person::getFullName)
        .ifPresent(System.out::println);

    // представим список в виде Map, где ключ - возраст, а значение - Person
    // по одному возрасту может быть несколько persons
        /*
        // Функция на вход принимает Person,
        // и возвращает значение, по которому нужно сгруппировать
        // это значение и будет КЛЮЧОМ, если эти ключи будут совпадать,
        // то получим НЕСКОЛЬКО Persons по одному ключу
        Function<? super Person, ? extends Integer> classifier = Person::getAge;
        Collector<Person, ?, Map<Integer, List<Person>>> collector =
            Collectors.groupingBy(classifier);
         */

    Map<Integer, List<Person>> mapOfPersons = doctors.stream()
        .collect(groupingBy(Person::getAge));
    mapOfPersons.forEach((key, value) ->
        System.out.printf("%d = %s\n", key, value));

    System.out.println("---------------------------------------------");
        /*
        Function<? super Person, ? extends String> mappingMapper = Person::getFullName;
        Collector<? super String, ?, List<String>> mappingDownstream = Collectors.toList();
        Collector<Person, ?, List<String>> downstream =
            Collectors.mapping(mappingMapper, mappingDownstream);
         */

    // with static import of
    //      Collectors.groupingBy(),
    //      Collectors.mapping(),
    //      Collectors.toList()
    Map<Integer, List<String>> mapOfFullNames = doctors.stream()
        .collect(groupingBy(Person::getAge,
            mapping(Person::getFullName, toList())));
    mapOfFullNames.forEach((key, value) ->
        System.out.printf("%d = %s\n", key, value));

    System.out.println("---------------------------------------------");

    // Создадим map, где ключом будет возраст, а значение - 1 person
        /*
        // Не будет работать в случае, если в списке doctors есть совпадающие ключи
        Map<Integer, Person> doctorMap = doctors.stream()
            .collect(toMap(Person::getAge, person -> person));
         */
        /*
        Map<Integer, Person> doctorMap = doctors.stream()
            .collect(toMap(Person::getAge, Function.identity()));
         */

  }
}

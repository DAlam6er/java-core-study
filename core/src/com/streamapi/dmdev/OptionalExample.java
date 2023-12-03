package com.streamapi.dmdev;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalExample {
  public static void main(String[] args) {
    Optional<Student> maybeStudent = Stream.of(
            new Student(18, "Ivan"),
            new Student(23, "Peter"),
            new Student(34, "Vasya"),
            new Student(45, "Sveta"),
            new Student(20, "Katya"),
            new Student(68, "Den"),
            new Student(101, "Kira")
        )
        //.parallel()                       // обработка в несколько потоков
        .sequential()                       // свернуть вычисление в 1 поток
        //.map(Student::getAge)
        //.flatMap(student -> student.getMarks().stream())
        //.map(mark -> )
        //.reduce(Math::max)
        //.reduce(0, Integer::sum)
        //.reduce(Integer::sum)
        //.filter(student -> student.getAge() < 18)
        .reduce(((student1, student2) ->
            student1.getAge() > student2.getAge() ? student1 : student2));

    maybeStudent.ifPresent(System.out::println);
    maybeStudent.map(Student::getAge)       // функция внутри map может вернуть null, тогда map вернет empty Optional
        .filter(age -> age > 25)
        //.stream()                         // stream из 1 объекта
        //.flatMap(age -> Optional.ofNullable(null)) // функция внутри flatMap ОБЯЗАНА вернуть Optional
        .flatMap(age -> Optional.of(age * 2))
        .ifPresent(System.out::println);
  }
}

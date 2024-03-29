package com.streamapi.ylabuniversity;

import com.streamapi.ylabuniversity.dto.Author;
import com.streamapi.ylabuniversity.dto.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class MapExamples {
  public static void main(String[] args) {
    Author kant = new Author();
    kant.setAge(45);
    kant.setName("Immanuil");

    List<Book> booksKant = new ArrayList<>();

    Book critique = new Book();
    critique.setName("The Critique of Pure Reason");
    critique.setPages(800);

    Book habits = new Book();
    habits.setName("The more habits, the less freedom");
    habits.setPages(450);

    booksKant.add(critique);
    booksKant.add(habits);
    kant.setBooks(booksKant);

    Author nicshe = new Author();
    nicshe.setAge(38);
    nicshe.setName("Fridrih");

    List<Book> booksNicshe = new ArrayList<>();

    Book good = new Book();
    good.setName("On the other side of good and evil");
    good.setPages(800);

    Book zaratustra = new Book();
    zaratustra.setName("Thus spoke Zarathustra");
    zaratustra.setPages(300);

    booksNicshe.add(good);
    booksNicshe.add(zaratustra);
    nicshe.setBooks(booksNicshe);

    Author gete = new Author();
    gete.setAge(55);
    gete.setName("Iogann");

    List<Book> booksGete = new ArrayList<>();

    Book faust = new Book();
    faust.setName("Faust");
    faust.setPages(800);

    Book prometheus = new Book();
    prometheus.setName("Prometheus");
    prometheus.setPages(300);

    Book mignon = new Book();
    mignon.setName("Mignon");
    mignon.setPages(300);

    booksGete.add(faust);
    booksGete.add(prometheus);
    booksGete.add(mignon);
    gete.setBooks(booksGete);

    List<Author> authors = new ArrayList<>();
    authors.add(kant);
    authors.add(nicshe);
    authors.add(gete);

    //        List<String> names = authors.stream()
    //                .filter(Objects::nonNull)
    //                .map(author -> author.getName())
    //                .peek(name -> System.out.println(name)) // log.debug("");
    //                .collect(Collectors.toList());
    //        System.out.println(names);

    List<String> namesSorted = authors.stream()
        .map(author -> author.getName())
        .sorted(Comparator.comparing(String::length).reversed()) // [Immanuil, Fridrih, Iogann]
        .collect(Collectors.toList());
    System.out.println(namesSorted);
    //
    //
    //        List<String> books = authors.stream()
    //                .map(author -> author.getBooks())
    //                .flatMap(list -> list.stream())
    //                .map(book -> book.getName())
    //                .collect(Collectors.toList());
    //        System.out.println(books);
    //
    //
    //        List<Integer> together = Stream.of(asList(1, 4), asList(5, 6, 7))
    //                .flatMap(numbers -> numbers.stream())
    //                .collect(Collectors.toUnmodifiableList());
    //        System.out.println(together);
    //
    //        Map<String, Integer> bookMap = authors.stream()
    //                .collect(Collectors.toMap(Author::getName, author -> author.getBooks().size()));
    //        System.out.println(bookMap);
    //
    //        Map<Integer, List<String>> grouping = authors.stream()
    //                .collect(Collectors.groupingBy(author -> author.getBooks().size(),
    //                        mapping(Author::getName, toList())));
    //        System.out.println(grouping);
    //
    //
    //        System.out.println(bookMap.computeIfAbsent("key", s -> s.length()));

  }
}

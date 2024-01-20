package com.streamapi.warburton.chap05;

import com.streamapi.warburton.chap01.Artist;
import com.streamapi.warburton.chap03.TestArtists;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Реализовать следующие задачи с помощью ссылок на методы:
 * - перевод в верхний регистр
 * - реализация count с помощью reduce
 * - конкатенация списков на основе flatMap
 */
public class Task01 {
  public static void main(String[] args) {
    List<String> collected = Stream.of("a", "b", "hello")
        .map(String::toUpperCase)
        .collect(toList());
    System.out.println(collected);

    List<Artist> artists = TestArtists.ARTISTS;
    long numberOfArtistThroughCount = artists.stream()
        .flatMap(Artist::getMembers)
        .count();

    long numberOfArtistsThroughReduce = artists.stream()
        .flatMap(Artist::getMembers)
        .mapToLong(artist -> 1L)
        .reduce(0L, Long::sum);

    List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
        .flatMap(Collection::stream)
        .collect(toList());

    System.out.println("Число исполнителей в списке: " + numberOfArtistsThroughReduce);
    System.out.println("Размер списка исполнителей: " + artists.size());
  }
}

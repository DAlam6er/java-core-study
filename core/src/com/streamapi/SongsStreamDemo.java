package com.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// FROM headFirst 3d edition
public class SongsStreamDemo {
  public static void main(String[] args) {
    SongsStreamDemo songsStream = new SongsStreamDemo();

    List<Song> songs = songsStream.getSongs();
    songs.forEach(System.out::println);
    System.out.println();

    songsStream.getRockSongs(songs).forEach(System.out::println);
    System.out.println();

    songsStream.getKindaRockSongs(songs).forEach(System.out::println);
    System.out.println();

    songsStream.getBeatlesSongs(songs).forEach(System.out::println);
    System.out.println();

    songsStream.getSongsStartWithH(songs).forEach(System.out::println);
    System.out.println();

    songsStream.getSongsRecentThan1995(songs).forEach(System.out::println);
    System.out.println();

    songsStream.getSongsGenres(songs).forEach(song -> System.out.print(song + "; "));
    System.out.println();

    songsStream.printTopFiveSongs(songs).forEach(song -> System.out.print(song + "; "));
    System.out.println();

    Optional<Song> result = songsStream.search("The Beatles", songs);
    System.out.println(result.orElseThrow(() -> new RuntimeException("Element not found")));
  }

  public List<Song> getSongs() {
    return List.of(
        new Song("$10", "Hitchhiker", "Electronic", 2016, 183),
        new Song("Havana", "Camila Cabello", "R&B", 2017, 324),
        new Song("Cassidy", "Grateful Dead", "Rock", 1972, 123),
        new Song("50 ways", "Paul Simon", "Soft Rock", 1975, 199),
        new Song("Hurt", "Nine Inch Nails", "Industrial Rock", 1995, 257),
        new Song("Silence", "Delirium", "Electronic", 1999, 134),
        new Song("Hurt", "Johnny Cash", "Soft Rock", 2002, 392),
        new Song("Watercolour", "Pendulum", "Electronic", 2010, 155),
        new Song("The Outsider", "A Perfect Circle", "Alternative Rock", 2004, 312),
        new Song("With a Little Help from My Friends", "The Beatles", "Rock", 1967, 168),
        new Song("Come Together", "The Beatles", "Blues rock", 1968, 173),
        new Song("Come Together", "Ike & Tina Turner", "Rock", 1970, 165),
        new Song("With a Little Help from My Friends", "Joe Cocker", "Rock", 1968, 46),
        new Song("Immigrant Song", "Karen O", "Industrial Rock", 2011, 12),
        new Song("Breathe", "The Prodigy", "Electronic", 1996, 337),
        new Song("What's Going On", "Gaye", "R&B", 1971, 420),
        new Song("Hallucinate", "Dua Lipa", "Pop", 2020, 75),
        new Song("Walk Me Home", "P!nk", "Pop", 2019, 459),
        new Song("I am not a woman, I'm a god", "Halsey", "Alternative Rock", 2021, 384),
        new Song("Pasos de cero", "Pablo Alborán", "Latin", 2014, 117),
        new Song("Smooth", "Santana", "Latin", 1999, 244),
        new Song("Immigrant song", "Led Zeppelin", "Rock", 1970, 484)
    );
  }

  public List<Song> getRockSongs(List<Song> originalList) {
    // .filter() принимает Predicate (boolean test(T t))
    // лямбда-выражение справа реализует функциональный интерфейс Predicate
    Predicate<Song> predicate = song -> "Rock".equals(song.getGenre());
    return originalList.stream()
        .filter(predicate)
        .collect(Collectors.toList());
  }

  public List<Song> getKindaRockSongs(List<Song> originalList) {
    return originalList.stream()
        .filter(song -> song.getGenre().contains("Rock"))
        .collect(Collectors.toList());
  }

  public List<Song> getBeatlesSongs(List<Song> originalList) {
    return originalList.stream()
        .filter(song -> "The Beatles".equals(song.getArtist()))
        .collect(Collectors.toList());
  }

  public List<Song> getSongsStartWithH(List<Song> originalList) {
    return originalList.stream()
        .filter(song -> song.getTitle().startsWith("H"))
        .collect(Collectors.toList());
  }

  public List<Song> getSongsRecentThan1995(List<Song> originalList) {
    return originalList.stream()
        .filter(song -> song.getYear() < 1995)
        .collect(Collectors.toList());
  }

  public List<String> getSongsGenres(List<Song> originalList) {
    return originalList.stream()
        .map(song -> song.getGenre())
        .distinct()
        .collect(Collectors.toList());
  }

  public List<String> printTopFiveSongs(List<Song> originalList) {
    return originalList.stream()
        .sorted(Comparator.comparingInt(Song::getTimesPlayed))
        .map(Song::getTitle)
        .limit(5)
        .collect(Collectors.toList());
  }

  public Optional<Song> search(String artist, List<Song> originalList) {
    return originalList.stream()
        .filter(song -> song.getArtist().equals(artist))
        .findFirst();
  }

}

class Song {
  private final String title;
  private final String artist;
  private final String genre;
  private final int year;
  private final int timesPlayed;

  public Song(String title, String artist, String genre, int year, int timesPlayed) {
    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.year = year;
    this.timesPlayed = timesPlayed;
  }

  public String getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  public String getGenre() {
    return genre;
  }

  public int getYear() {
    return year;
  }

  public int getTimesPlayed() {
    return timesPlayed;
  }

  @Override
  public String toString() {
    return "Song{" +
           "title='" + title + '\'' +
           ", artist='" + artist + '\'' +
           ", genre='" + genre + '\'' +
           ", year=" + year +
           ", timesPlayed=" + timesPlayed +
           '}';
  }
}

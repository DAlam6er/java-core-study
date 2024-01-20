package com.streamapi.warburton.chap03;

import com.streamapi.warburton.chap01.Album;
import com.streamapi.warburton.chap01.Artist;
import com.streamapi.warburton.chap01.Track;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Реализуйте
 * - функцию сложения чисел, т.е. int addUp(Stream<Integer> numbers)
 * - функцию, которая получает исполнителя и возвращает список строк, содержащих имена и место происхождения
 * - функцию, которая получает альбомы и возвращает список альбомов, содержащих не более 3 произведений
 */
public class Task01 {
  public static void main(String[] args) {
    int sum = addUp(Stream.of(1, 2, 3, 4, 5));
    System.out.println("Сумма чисел 1..5: " + sum);

    List<Artist> beatles = List.of(
        new Artist("John Lennon", "English"),
        new Artist("Paul McCartney", "English"),
        new Artist("George Harrison", "English"),
        new Artist("Ringo Starr", "English"));
    List<String> artistDescription = getNamesAndOrigins(beatles);
    artistDescription.forEach(System.out::println);

    List<Track> pleasePleaseMeTrackList = List.of(
        new Track("I Saw Her Standing There", 172),
        new Track("Misery", 107),
        new Track("Anna (Go to Him)", 174),
        new Track("Chains", 143),
        new Track("Boys", 144),
        new Track("Ask Me Why", 144),
        new Track("Please Please Me", 120),
        new Track("Love Me Do", 139),
        new Track("P.S. I Love You", 122),
        new Track("Baby It's You", 155),
        new Track("Do You Want to Know a Secret", 116),
        new Track("A Taste of Honey", 121),
        new Track("There's a Place", 109),
        new Track("Twist and Shout", 153)
        );
    Album album1 = new Album("Please Please Me", pleasePleaseMeTrackList, beatles);

    List<Artist> ledZeppelin = List.of(
        new Artist("Jimmy Page", "English"),
        new Artist("John Bonham", "English"),
        new Artist("Robert Plant", "English"),
        new Artist("John Paul Jones", "English")
    );
    List<Track> ledZeppelinTrackList = List.of(
        new Track("Good Times, Bad Times", 166),
        new Track("Babe I’m Gonna Leave You", 401)
    );
    Album album2 = new Album("Led Zeppelin", ledZeppelinTrackList, ledZeppelin);

    List<Album> albumsWithThreeOrLessTracks = getAlbumsWithThreeOrLessTracks(album1, album2);
    System.out.println("\nСписок альбомов с количеством треков меньше, либо равным 3:");
    albumsWithThreeOrLessTracks.forEach(album -> System.out.println(album.getName()));
  }

  public static List<Album> getAlbumsWithThreeOrLessTracks(Album... albums) {
    return Arrays.stream(albums)
        .filter(album -> album.getTrackList().size() <= 3)
        .collect(toList());
  }

  public static int addUp(Stream<Integer> numbers) {
    return numbers.mapToInt(Integer::intValue).sum();
  }

  private static List<String> getNamesAndOrigins(List<Artist> artists) {
    return artists.stream()
        .map(artist -> String.join(":", artist.getName(), artist.getNationality()))
        .collect(toList());
  }
}

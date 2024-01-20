package com.streamapi.warburton.chap03;

import com.streamapi.warburton.chap01.Artist;

import java.util.List;
import java.util.stream.Stream;

/**
 * Перепишите заданный код с использованием внутреннего итерирования вместо внешнего
 */
public class Task02 {
  public static void main(String[] args) {
    List<Artist> artists = TestArtists.ARTISTS;

    int totalMembers = 0;
    for (Artist artist : artists) {
      Stream<Artist> members = artist.getMembers();
      totalMembers += members.count();
    }

    System.out.println("Общее количество участников: " + totalMembers);


    long totalMembers2 = countBandMembersInternal(artists);
    System.out.println("Общее количество участников: " + totalMembers2);
  }

  public static long countBandMembersInternal(List<Artist> artists) {
    return artists.stream()
        .flatMap(Artist::getMembers)
        .count();
  }
}

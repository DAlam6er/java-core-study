package com.streamapi.warburton.chap03;

import com.streamapi.warburton.chap01.Artist;

import java.util.List;

public class TestArtists {
  public static final List<Artist> ARTISTS;

  static {
    List<Artist> beatlesMembers = List.of(
        new Artist("John Lennon", "English"),
        new Artist("Paul McCartney", "English"),
        new Artist("George Harrison", "English"),
        new Artist("Ringo Starr", "English"));

    List<Artist> ledZeppelinMembers = List.of(
        new Artist("Jimmy Page", "English"),
        new Artist("John Bonham", "English"),
        new Artist("Robert Plant", "English"),
        new Artist("John Paul Jones", "English")
    );

    ARTISTS = List.of(
        new Artist("The Beatles", beatlesMembers, "English"),
        new Artist("Led Zeppelin", ledZeppelinMembers, "English")
    );
  }
}

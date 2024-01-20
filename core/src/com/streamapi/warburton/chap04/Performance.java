package com.streamapi.warburton.chap04;

import com.streamapi.warburton.chap01.Artist;

import java.util.stream.Stream;

public interface Performance {
  String getName();
  Stream<Artist> getMusicians();
  default Stream<Artist> getAllMusicians() {
    return getMusicians()
        .flatMap(artist -> Stream.concat(Stream.of(artist), artist.getMembers()));
  }
}

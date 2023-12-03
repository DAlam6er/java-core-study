package com.collections.headfirst.examples.jukebox;

class Song implements Comparable<Song> {
  private final String title;
  private final String artist;
  private final String rating;
  private final String bpm;

  Song(String title, String artist, String rating, String bpm) {
    this.title = title;
    this.artist = artist;
    this.rating = rating;
    this.bpm = bpm;
  }

  public String getArtist() {
    return artist;
  }

  public String getRating() {
    return rating;
  }

  public String getBpm() {
    return bpm;
  }

  @Override
  public int compareTo(Song song) {
    return this.getTitle().compareTo(song.getTitle());
  }

  public String getTitle() {
    return title;
  }

  @Override
  public int hashCode() {
    return title.hashCode();
  }

  @Override
  public boolean equals(Object song) {
    Song s = (Song) song;
    return s.getTitle().equals(getTitle());
  }

  @Override
  public String toString() {
    //return String.format("%s: %s", title, artist);
    return String.format("%s", title);
  }
}

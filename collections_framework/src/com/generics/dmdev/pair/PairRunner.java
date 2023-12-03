package com.generics.dmdev.pair;

public class PairRunner {
  public static void main(String[] args) {
    Pair<String, Integer> pair = new Pair<>("Адрес", 666);
    System.out.println(pair);

    Pair<Integer, String> swappedPair = PairUtil.swap(pair);
    System.out.println(swappedPair);
  }
}

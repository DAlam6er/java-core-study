package com.cryptographic;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Demo {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("usage: Base64Demo text");
      System.exit(1);
    }

    String originalString = args[0];
    String encodedString = Base64.getEncoder()
        .encodeToString(originalString.getBytes(StandardCharsets.UTF_8));
    System.out.println("encoded string = " + encodedString);

    byte[] decodedBytes = Base64.getDecoder()
        .decode(encodedString);
    String decodedString = new String(decodedBytes);
    System.out.println("decoded string = " + decodedString);
  }
}

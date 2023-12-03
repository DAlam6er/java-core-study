package com.nio.bodrov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class NioExamples {

  public static void main(String[] args) {
    Path input = Path.of("input.txt");
    Path output = Path.of("output.txt");

    System.out.println(input.getClass().getSimpleName());
    System.out.println("hello".getClass());

    try {
      Files.copy(input, output, StandardCopyOption.REPLACE_EXISTING);
      Files.writeString(output, System.lineSeparator()
                                + "zzz", StandardOpenOption.APPEND);

      List<String> lines = Files.readAllLines(output);
      System.out.println(lines);
      System.out.println(lines.getClass().getCanonicalName());

    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}

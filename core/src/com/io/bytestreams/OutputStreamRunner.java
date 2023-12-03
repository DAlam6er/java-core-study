package com.io.bytestreams;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class OutputStreamRunner {
  public static void main(String[] args) {
    File file = Path.of("resources", "output.txt").toFile();
    try (BufferedOutputStream out = new BufferedOutputStream(
        new FileOutputStream(file, true))) {
      String value = "Hello World";
      out.write(value.getBytes());
      out.write(System.lineSeparator().getBytes());
    } catch (IOException ignored) {
    }
  }
}

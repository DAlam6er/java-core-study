package com.io.bytestreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Считать стихотворение из файла и вывести его на консоль
 */
// from dmdev
public class InputStreamRunner {
  public static void main(String[] args) {
    // java.io
    // File file = new File(String.join(File.separator, "resources", "poem.txt"));
    // java.nio
    File file = Path.of("resources", "poem.txt").toFile();
    try (FileInputStream inputStream = new FileInputStream(file)) {
      // Чаще всего считывают по порциям, не забивая ОЗУ большими объемами
      // и перенаправляют эти порции конечному пользователю
            /*
            byte[] bytes = inputStream.readAllBytes();
            String stringValue = new String(bytes);
            System.out.println(stringValue);
             */
      byte[] bytes = new byte[inputStream.available()];
      int counter = 0;
      byte currentByte;
      while ((currentByte = (byte) inputStream.read()) != -1) {
        bytes[counter++] = currentByte;
      }
      String stringValue = new String(bytes);
      System.out.println(stringValue);
      System.out.println("\nSize: " + bytes.length + " bytes.");
    } catch (IOException ignored) {
    }
  }
}

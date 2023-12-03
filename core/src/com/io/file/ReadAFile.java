package com.io.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadAFile {
  public static void main(String[] args) {
    File myFile = new File("foo.txt");
    // FileReader - поток соединения для символов.
    // Подключается к текстовому файлу
    // BufferedReader повышает эффективность чтения: FileReader
    // будет обращаться к файлу только в том случае, если буфер будет пуст.
    try (FileReader fileReader = new FileReader(myFile);
         BufferedReader reader = new BufferedReader(fileReader)) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}

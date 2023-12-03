package com.horstmann.impatient.chap02;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * Напишите класс с методом main() для чтения избранных файлов формата CSV
 * и вывода некоторого их содержимого с помощью библиотеки OpenCSV
 */
public class Task13 {
  public static void main(String[] args) throws Exception {
    File file = Path.of("out", "production", "core", "data.csv").toFile();
    if (file.exists()) {
      try (CSVReader reader = new CSVReaderBuilder(new FileReader(file)).build()) {
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
          System.out.println(nextLine[0]);
        }
      }
      System.out.println();
      // Read all lines into a List<String[]>
      try (CSVReader reader = new CSVReaderBuilder(new FileReader(file)).build()) {
        List<String[]> myEntries = reader.readAll();
        myEntries.forEach(entry -> System.out.println(Arrays.toString(entry)));
      }
      System.out.println();
    }
  }
}

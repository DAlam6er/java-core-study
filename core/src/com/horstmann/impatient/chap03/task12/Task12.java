package com.horstmann.impatient.chap03.task12;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Используя метод list(FilenameFilter) из класса java.io.File, напишите метод,
 * возвращающий все файлы из заданного каталога с указанным расширением. Воспользуйтесь для
 * этой цели лямбда-выражением вместо объекта типа FilenameFilter. Какая переменная из
 * объемлющей области действия захватывается лямбда-выражением?
 */
public class Task12 {
  public static void main(String[] args) {
    Path inputDir = Path.of("D:", "prog", "VBA", "Projects", "TSAR");
    String extension = ".xlsx";
    File[] files = getFilesWithExtension(inputDir, extension);
    System.out.printf("Файлы в каталоге %s с расширением %s:\n", inputDir.getFileName(), extension);
    Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
  }

  public static File[] getFilesWithExtension(Path inputDir, String extension) {
    if (inputDir.toFile().isDirectory()) {
      return inputDir.toFile().listFiles((dir, name) -> name.contains(extension));
    } else {
      System.out.println("Указанный файл не является директорией!");
      return new File[0];
    }
  }
}

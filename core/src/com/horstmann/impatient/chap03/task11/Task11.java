package com.horstmann.impatient.chap03.task11;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Используя методы listFiles(FileFilter) и isDirectory из класса java.io.File,
 * напишите метод, возвращающий все подкаталоги из заданного каталога.
 * Воспользуйтесь для этой цели лямбда-выражением вместо объекта типа FileFilter.
 * Сделайте то же самое, используя ссылку на метод и анонимный внутренний класс.
 */
public class Task11 {
  public static void main(String[] args) {
    Path inputDir = Path.of("D:", "prog", "VBA", "Projects", "TSAR");
    //File[] subdirs = getSubdirsAnonymous(inputDir);
//    File[] subdirs = getSubdirsLambda(inputDir);
    File[] subdirs = getSubdirsMethReference(inputDir);
    System.out.println("Подкаталоги каталога " + inputDir.getFileName() + ":");
    Arrays.stream(subdirs).forEach(file -> System.out.println(file.getName()));
  }

  public static File[] getSubdirsAnonymous(Path catalog) {
    if (catalog.toFile().isDirectory()) {
      return catalog.toFile().listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
          return pathname.isDirectory();
        }
      });
    } else {
      System.out.println("Указанный файл не является директорией!");
      return new File[0];
    }
  }

  public static File[] getSubdirsLambda(Path catalog) {
    if (catalog.toFile().isDirectory()) {
      return catalog.toFile().listFiles(pathname -> pathname.isDirectory());
    } else {
      System.out.println("Указанный файл не является директорией!");
      return new File[0];
    }
  }

  public static File[] getSubdirsMethReference(Path catalog) {
    if (catalog.toFile().isDirectory()) {
      return catalog.toFile().listFiles(File::isDirectory);
    } else {
      System.out.println("Указанный файл не является директорией!");
      return new File[0];
    }
  }
}

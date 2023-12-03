package com.horstmann.impatient.chap03;

import com.horstmann.impatient.chap03.task11.Task11;
import com.horstmann.impatient.chap03.task12.Task12;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Если задан массив объектов типа File, отсортируйте его таким образом, чтобы каталоги
 * следовали перед файлами, а в каждой группе отсортируйте элементы по пути к ним.
 * Воспользуйтесь лябмда-выражением, чтобы указать компаратор типа Comparator.
 */
public class Task13 {
  public static void main(String[] args) {
    Path inputDir = Path.of("C:", "Windows");
    File[] mixedFiles = initializeMixedArrayOfFiles(inputDir);
    System.out.println("Mixed list of files:");
    Arrays.stream(mixedFiles).forEach(file -> System.out.println(file.getAbsolutePath()));
    File[] sorted = sort(mixedFiles);
    System.out.println("\nSorted files:");
    Arrays.stream(sorted).forEach(file -> System.out.println(file.getAbsolutePath()));
  }

  private static File[] sort(File[] mixedFiles) {
    return Arrays.stream(mixedFiles)
        .sorted((file1, file2) -> {
          if (file1.isDirectory() && !file2.isDirectory()) {
            return -1;
          } else if (!file1.isDirectory() && file2.isDirectory()) {
            return 1;
          } else {
            return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
          }
        })
        .toArray(File[]::new);
  }

  private static File[] initializeMixedArrayOfFiles(Path inputDir) {

    List<File> subDirs = List.of(Task11.getSubdirsMethReference(inputDir));
    List<File> filesWithExtension = List.of(Task12.getFilesWithExtension(inputDir, "."));
    List<File> mixedList = new ArrayList<>(subDirs);
    mixedList.addAll(filesWithExtension);

    Collections.shuffle(mixedList);
    return mixedList.toArray(new File[0]);
  }
}

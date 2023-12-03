package com.io.file;

import java.io.File;
import java.io.IOException;

/**
 * application --> file (output stream) - выходной поток байтов
 * application <-- file (input stream)  - входной  поток байтов
 */
// from dmdev
public class FileRunner {
  public static void main(String[] args) throws IOException {
    // логическое представление файла
    // логическое и физическое представление могут не соотвествовать
    File file = new File("resources/test.txt");
    System.out.println(file.createNewFile());
    System.out.println(file.exists());
    System.out.println(file.isFile());
    System.out.println(file.isDirectory());
    System.out.println(file.getName());
    System.out.println(file.getParent());
    System.out.println(file.length());
    System.out.println(file.canExecute());
    System.out.println(file.canWrite());
    System.out.println(file.canRead());
    System.out.println(file.getAbsolutePath());
    System.out.println(file.getCanonicalPath());

    File dir = new File("resources/test/dir");
    dir.mkdirs();
  }
}
